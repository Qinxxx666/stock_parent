package org.qin.com.stock.service.impl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.qin.com.stock.config.StockInfoConfig;
import org.qin.com.stock.constant.ParseType;
import org.qin.com.stock.dao.*;
import org.qin.com.stock.entity.StockRtInfo;
import org.qin.com.stock.service.StockTimerTaskService;
import org.qin.com.stock.utils.IdWorker;
import org.qin.com.stock.utils.ParserStockInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Title: StockTimerTaskServiceImpl
 * @Author Qin
 * @Package org.qin.com.stock.service.impl
 * @Version
 * @Date 2025/2/7 14:20
 * @description:
 */
@Service("stockTimerTaskService")
@Slf4j
public class StockTimerTaskServiceImpl implements StockTimerTaskService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpEntity<Object> httpEntity;

    @Autowired
    private StockInfoConfig stockInfoConfig;

    @Autowired
    private StockMarketIndexInfoDao stockMarketIndexInfoDao;

    @Autowired
    private StockOuterMarketIndexInfoDao stockOuterMarketIndexInfoDao;

    @Autowired
    private StockBlockRtInfoDao stockBlockRtInfoDao;

    @Autowired
    private StockBusinessDao stockBusinessDao;

    @Autowired
    private StockRtInfoDao stockRtInfoDao;

    @Override
    public void getInnerMarketInfo() {
        //数据采集
        String url=stockInfoConfig.getMarketUrl() + String.join(",",stockInfoConfig.getInner());
        String result = restTemplate.postForObject(url,httpEntity,String.class);
        //数据处理

        List infos;
        infos = ParserStockInfoUtil.parser4StockOrMarketInfo(result,ParseType.INNER);

        //批量插入
        if (!CollectionUtils.isEmpty(infos)) {
            int count = stockMarketIndexInfoDao.insertBatch(infos);
            log.info(String.valueOf(count));
        }
    }

    @Override
    public void getOuterMarketInfo() {
        //数据采集
        String url=stockInfoConfig.getMarketUrl() + String.join(",",stockInfoConfig.getOuter());
        String result = restTemplate.postForObject(url,httpEntity,String.class);

        //数据处理
        List infos;
        infos = ParserStockInfoUtil.parser4StockOrMarketInfo(result,ParseType.OUTER);

        //批量插入
        if (!CollectionUtils.isEmpty(infos)) {
            int count = stockOuterMarketIndexInfoDao.insertBatch(infos);
            log.info(String.valueOf(count));
        }
    }

    @Override
    public void getStockInfo() {
        //批量获取股票ID集合
        List<String> stockIds = stockBusinessDao.getStockIds();
        stockIds = stockIds.stream().map(id -> id.startsWith("6") ? "sh" + id : "sz" + id).toList();

        //对股票ID进行分组处理，每20个一组
        Lists.partition(stockIds,20).forEach(ids->{
            //数据采集
            String stockUrl=stockInfoConfig.getMarketUrl()+String.join(",",ids);
            String result = restTemplate.postForObject(stockUrl,httpEntity,String.class);

            //数据处理
            List infos;
            infos = ParserStockInfoUtil.parser4StockOrMarketInfo(result, ParseType.ASHARE);

            //批量插入数据库
            if (!CollectionUtils.isEmpty(infos)) {
                int count = stockRtInfoDao.insertBatch(infos);
                log.info(String.valueOf(count));
            }
        });
    }

    @Override
    public void getBlockInfo() {
        //数据采集
        String url = stockInfoConfig.getBlockUrl();
        String result = restTemplate.postForObject(url,httpEntity,String.class);

        //数据处理
        List infos;
        infos = ParserStockInfoUtil.parse4StockBlock(result);

        //批量插入数据库
        if (!CollectionUtils.isEmpty(infos)) {
            int count = stockBlockRtInfoDao.insertBatch(infos);
            log.info(String.valueOf(count));
        }
    }
}
