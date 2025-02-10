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
    private IdWorker idWorker;

    @Autowired
    private ParserStockInfoUtil parserStockInfoUtil;

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
        String url=stockInfoConfig.getMarketUrl() + String.join(",",stockInfoConfig.getInner());
        String result = restTemplate.postForObject(url,httpEntity,String.class);

        List infos;
        infos = ParserStockInfoUtil.parser4StockOrMarketInfo(result,1);

//        String reg="var hq_str_(.+)=\"(.+)\";";
//        Pattern pattern = Pattern.compile(reg);
//        Matcher matcher = pattern.matcher(result);
//
//        ArrayList<StockMarketIndexInfo> list = new ArrayList<>();
//        while (matcher.find()){
//            //获取大盘的code
//            String marketCode = matcher.group(1);
//            //获取其它信息，字符串以逗号间隔
//            String otherInfo=matcher.group(2);
//            //以逗号切割字符串，形成数组
//            String[] splitArr = otherInfo.split(",");
//            //大盘名称
//            String marketName=splitArr[0];
//            //获取当前大盘的开盘点数
//            BigDecimal openPoint=new BigDecimal(splitArr[1]);
//            //前收盘点
//            BigDecimal preClosePoint=new BigDecimal(splitArr[2]);
//            //获取大盘的当前点数
//            BigDecimal curPoint=new BigDecimal(splitArr[3]);
//            //获取大盘最高点
//            BigDecimal maxPoint=new BigDecimal(splitArr[4]);
//            //获取大盘的最低点
//            BigDecimal minPoint=new BigDecimal(splitArr[5]);
//            //获取成交量
//            Long tradeAmt=Long.valueOf(splitArr[8]);
//            //获取成交金额
//            BigDecimal tradeVol=new BigDecimal(splitArr[9]);
//            //时间
//            // 定义日期时间格式
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//            // 解析日期时间字符串
//            LocalDateTime dateTime = LocalDateTime.parse(splitArr[30] + " " + splitArr[31], formatter);
//
//            // 去掉秒和纳秒
//            LocalDateTime dateTimeWithoutSeconds = dateTime.withSecond(0).withNano(0);
//
//            // 转换为 Date
//            Date curTime = Date.from(dateTimeWithoutSeconds.atZone(ZoneId.systemDefault()).toInstant());
//
//            //封装对象
//            StockMarketIndexInfo info = StockMarketIndexInfo.builder()
//                    .id(idWorker.nextId())
//                    .marketCode(marketCode)
//                    .marketName(marketName)
//                    .curPoint(curPoint)
//                    .openPoint(openPoint)
//                    .preClosePoint(preClosePoint)
//                    .maxPoint(maxPoint)
//                    .minPoint(minPoint)
//                    .tradeVolume(tradeVol)
//                    .tradeAmount(tradeAmt)
//                    .curTime(curTime)
//                    .build();
//            //收集封装的对象，方便批量插入
//            list.add(info);
//        }
        //批量插入
        if (!CollectionUtils.isEmpty(infos)) {
            int count = stockMarketIndexInfoDao.insertBatch(infos);
            log.info(String.valueOf(count));
        }
    }

    @Override
    public void getOuterMarketInfo() {
        String url=stockInfoConfig.getMarketUrl() + String.join(",",stockInfoConfig.getOuter());
        String result = restTemplate.postForObject(url,httpEntity,String.class);

        List infos;
        infos = ParserStockInfoUtil.parser4StockOrMarketInfo(result,2);

//        String reg="var hq_str_(.+)=\"(.+)\";";
//        Pattern pattern = Pattern.compile(reg);
//        Matcher matcher = pattern.matcher(result);
//
//        ArrayList<StockOuterMarketIndexInfo> infos = new ArrayList<>();
//
//        Date curTime = TimeUtil.nowWithoutSec();
//
//        while(matcher.find()){
//            String marketCode = matcher.group(1);
//            String otherInfo = matcher.group(2);
//            String[] splitArr = otherInfo.split(",");
//
//            StockOuterMarketIndexInfo info = StockOuterMarketIndexInfo.builder().
//                    id(idWorker.nextId()).
//                    marketCode(marketCode).
//                    marketName(splitArr[0]).
//                    curPoint(new BigDecimal(splitArr[1])).
//                    updown(new BigDecimal(splitArr[2])).
//                    rose(new BigDecimal(splitArr[3])).
//                    curTime(curTime).
//                    build();
//            infos.add(info);
//        }
        if (!CollectionUtils.isEmpty(infos)) {
            int count = stockOuterMarketIndexInfoDao.insertBatch(infos);
            log.info(String.valueOf(count));
        }
    }

    @Override
    public void getStockInfo() {
        //批量获取股票ID集合
        List<String> stockIds = stockBusinessDao.getStockIds();
        //计算出符合sina命名规范的股票id数据（jdk17之前用下列注释中得写法
        stockIds = stockIds.stream().map(id -> id.startsWith("6") ? "sh" + id : "sz" + id).toList();
//        stockIds = stockIds.stream().map(id -> {
//            return id.startsWith("6") ? "sh" + id : "sz" + id;
//        }).collect(Collectors.toList());
        log.info(stockIds.toString());
        Lists.partition(stockIds,20).forEach(ids->{
            System.out.println(ids);
            //拼接股票url地址
            String stockUrl=stockInfoConfig.getMarketUrl()+String.join(",",ids);
            //获取响应数据
            String result = restTemplate.getForObject(stockUrl, String.class);
            List<StockRtInfo> infos = parserStockInfoUtil.parser4StockOrMarketInfo(result, ParseType.ASHARE);
            log.info("数据量：{}",infos.size());
            //批量插入数据库
//            if (!CollectionUtils.isEmpty(infos)) {
//                int count = stockRtInfoDao.insertBatch(infos);
//                log.info(String.valueOf(count));
//            }
        });
    }

    @Override
    public void getBlockInfo() {
        String url = stockInfoConfig.getBlockUrl();
        String result = restTemplate.postForObject(url,httpEntity,String.class);

        List infos;
        infos = ParserStockInfoUtil.parse4StockBlock(result);

//        // 正则表达式匹配键值对
//        Pattern pattern = Pattern.compile("\"([^\"]+)\":\"([^\"]+)\"");
//        Matcher matcher = pattern.matcher(result);
//
//        Date curTime = TimeUtil.nowWithoutSec();
//
//        ArrayList<StockBlockRtInfo> infos = new ArrayList<>();
//
//        while(matcher.find()){
//            String[] splitArr = matcher.group(2).split(",");
//
//            StockBlockRtInfo info = StockBlockRtInfo.builder().
//                    id(idWorker.nextId()).
//                    label(splitArr[0]).
//                    blockName(splitArr[1]).
//                    companyNum(Integer.parseInt(splitArr[2])).
//                    avgPrice(new BigDecimal(splitArr[3])).
//                    updownRate(new BigDecimal(splitArr[5])).
//                    tradeAmount(Long.parseLong(splitArr[6])).
//                    tradeVolume(new BigDecimal(splitArr[7])).
//                    curTime(curTime).
//                    build();
//            infos.add(info);
//            log.info(info.getId().toString());
//        }

        if (!CollectionUtils.isEmpty(infos)) {
            int count = stockBlockRtInfoDao.insertBatch(infos);
            log.info(String.valueOf(count));
        }
    }
}
