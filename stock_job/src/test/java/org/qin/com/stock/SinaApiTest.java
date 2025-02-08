package org.qin.com.stock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.qin.com.stock.dao.StockBlockRtInfoDao;
import org.qin.com.stock.dao.StockMarketIndexInfoDao;
import org.qin.com.stock.dao.StockOuterMarketIndexInfoDao;
import org.qin.com.stock.entity.StockBlockRtInfo;
import org.qin.com.stock.entity.StockMarketIndexInfo;
import org.qin.com.stock.entity.StockOuterMarketIndexInfo;
import org.qin.com.stock.service.impl.StockTimerTaskServiceImpl;
import org.qin.com.stock.utils.HttpUtil;
import org.qin.com.stock.utils.IdWorker;
import org.qin.com.stock.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: SinaApiTest
 * @Author Qin
 * @Package org.qin.com.stock
 * @Version
 * @Date 2025/2/7 10:22
 * @description:
 */

@Slf4j
@SpringBootTest
public class SinaApiTest {

    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    StockMarketIndexInfoDao stockMarketIndexInfoDao;
    @Autowired
    StockOuterMarketIndexInfoDao stockOuterMarketIndexInfoDao;
    @Autowired
    StockTimerTaskServiceImpl stockTimerTaskService;
    @Autowired
    StockBlockRtInfoDao stockBlockRtInfoDao;
    @Autowired
    IdWorker idWorker;
    /**
     * 测试新浪接口
     * 接口
     * http://hq.sinajs.cn/list=sh000001,sz399001
     * 参数
     * var hq_str_sh000001="上证指数,3358.9338,3361.5177,3398.6161,3417.0085,3358.9338,0,0,381243178,510307202948,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2022-06-30,15:30:39,00,";
     * 参数说明：
     * 0：指数名称
     * 1：开盘点
     * 2：前收盘点
     * 3：当前点
     * 4：最高点
     * 5：最低点
     * 8：成交量
     * 9：成交金额
     * 30：当前日期
     * 31：当前时间
     */
    @Test
    public void testsina01(){
        //1.定义采集的url接口
        //String url=stockInfoConfig.getMarketUrl() + String.join(",",stockInfoConfig.getInner());
        String url = "http://hq.sinajs.cn/list=sh000001,sz399001";
        //2.调用restTemplate采集数据
        //2.1 组装请求头
        HttpHeaders headers = new HttpHeaders();
        //必须填写，否则数据采集不到
        headers.add("Referer","https://finance.sina.com.cn/stock/");
        headers.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
        //2.2 组装请求对象
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        //2.3 resetTemplate发起请求
        String resString = restTemplate.postForObject(url, entity, String.class);
//        log.info("当前采集的数据：{}",resString);
        //3.数据解析（重要）
//        var hq_str_sh000001="上证指数,3267.8103,3283.4261,3236.6951,3290.2561,3236.4791,0,0,402626660,398081845473,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2022-04-07,15:01:09,00,";
//        var hq_str_sz399001="深证成指,12101.371,12172.911,11972.023,12205.097,11971.334,0.000,0.000,47857870369,524892592190.995,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,2022-04-07,15:00:03,00";
        String reg="var hq_str_(.+)=\"(.+)\";";
        //编译表达式,获取编译对象
        Pattern pattern = Pattern.compile(reg);
        //匹配字符串
        Matcher matcher = pattern.matcher(resString);
        ArrayList<StockMarketIndexInfo> list = new ArrayList<>();
        //判断是否有匹配的数值
        while (matcher.find()){
            //获取大盘的code
            String marketCode = matcher.group(1);
            //获取其它信息，字符串以逗号间隔
            String otherInfo=matcher.group(2);
            //以逗号切割字符串，形成数组
            String[] splitArr = otherInfo.split(",");
            //大盘名称
            String marketName=splitArr[0];
            //获取当前大盘的开盘点数
            BigDecimal openPoint=new BigDecimal(splitArr[1]);
            //前收盘点
            BigDecimal preClosePoint=new BigDecimal(splitArr[2]);
            //获取大盘的当前点数
            BigDecimal curPoint=new BigDecimal(splitArr[3]);
            //获取大盘最高点
            BigDecimal maxPoint=new BigDecimal(splitArr[4]);
            //获取大盘的最低点
            BigDecimal minPoint=new BigDecimal(splitArr[5]);
            //获取成交量
            Long tradeAmt=Long.valueOf(splitArr[8]);
            //获取成交金额
            BigDecimal tradeVol=new BigDecimal(splitArr[9]);
            //时间
            // 定义日期时间格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // 解析日期时间字符串
            LocalDateTime dateTime = LocalDateTime.parse(splitArr[30] + " " + splitArr[31], formatter);

            // 去掉秒和纳秒
            LocalDateTime dateTimeWithoutSeconds = dateTime.withSecond(0).withNano(0);

            // 转换为 Date
            Date curTime = Date.from(dateTimeWithoutSeconds.atZone(ZoneId.systemDefault()).toInstant());

            //组装entity对象
            StockMarketIndexInfo info = StockMarketIndexInfo.builder()
                    .id(idWorker.nextId())
                    .marketCode(marketCode)
                    .marketName(marketName)
                    .curPoint(curPoint)
                    .openPoint(openPoint)
                    .preClosePoint(preClosePoint)
                    .maxPoint(maxPoint)
                    .minPoint(minPoint)
                    .tradeVolume(tradeVol)
                    .tradeAmount(tradeAmt)
                    .curTime(curTime)
                    .build();
            //收集封装的对象，方便批量插入
            list.add(info);
        }
        //批量插入
        if (!CollectionUtils.isEmpty(list)) {
            int count = stockMarketIndexInfoDao.insertBatch(list);
            log.info(String.valueOf(count));
        }
    }
    @Test
    public void testsina02(){
        String url = "http://hq.sinajs.cn/list=int_dji,int_nasdaq,int_hangseng,int_nikkei,b_FSSTI";
        String result = HttpUtil.get(url);

        String reg="var hq_str_(.+)=\"(.+)\";";

        Pattern pattern = Pattern.compile(reg);

        Matcher matcher = pattern.matcher(result);

        ArrayList<StockOuterMarketIndexInfo> infos = new ArrayList<>();

        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.withSecond(0).withNano(0);
        Date curTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        while(matcher.find()){
            String marketCode = matcher.group(1);
            String otherInfo = matcher.group(2);
            String[] splitArr = otherInfo.split(",");

            StockOuterMarketIndexInfo info = StockOuterMarketIndexInfo.builder().
                    marketCode(marketCode).
                    marketName(splitArr[0]).
                    curPoint(new BigDecimal(splitArr[1])).
                    updown(new BigDecimal(splitArr[2])).
                    rose(new BigDecimal(splitArr[3])).
                    curTime(curTime).
                    build();

            infos.add(info);
        }
        if (!CollectionUtils.isEmpty(infos)) {
            int count = stockOuterMarketIndexInfoDao.insertBatch(infos);
            log.info(String.valueOf(count));
        }

    }
    @Test
    public void testsina00(){
        stockTimerTaskService.getOuterMarketInfo();
    }

    /**
     * 数据格式：
     * "new_blhy,玻璃行业,19,19.293684210526,-0.17052631578947,-0.87610188740468,315756250,5258253314,sh600586,3.464,9.260,0.310,金晶科技"
     * 参数语义：
     * ['0.板块编码',1.'板块名称',2.'公司家数',3.'平均价格',4.'涨跌额',5.'涨跌幅',6.'总成交量',7.'总成交金额',8.'领涨股代码',9.'涨跌幅',10.'当前价',11.'涨跌额',12.'领涨股名称']
     */
    @Test
    public void testsina03(){
        String url = "https://vip.stock.finance.sina.com.cn/q/view/newSinaHy.php";
        String result = HttpUtil.get(url);

        // 正则表达式匹配键值对
        Pattern pattern = Pattern.compile("\"([^\"]+)\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(result);

        Date curTime = new TimeUtil().nowWithoutSec();

        ArrayList<StockBlockRtInfo> infos = new ArrayList<>();

        while(matcher.find()){
            String[] splitArr = matcher.group(2).split(",");

            StockBlockRtInfo info = StockBlockRtInfo.builder().
                    id(idWorker.nextId()).
                    label(splitArr[0]).
                    blockName(splitArr[1]).
                    companyNum(Integer.parseInt(splitArr[2])).
                    avgPrice(new BigDecimal(splitArr[3])).
                    updownRate(new BigDecimal(splitArr[5])).
                    tradeAmount(Long.parseLong(splitArr[6])).
                    tradeVolume(new BigDecimal(splitArr[7])).
                    curTime(curTime).
                    build();
            infos.add(info);
            log.info(info.getId().toString());
        }

        if (!CollectionUtils.isEmpty(infos)) {
            int count = stockBlockRtInfoDao.insertBatch(infos);
            log.info(String.valueOf(count));
        }
    }
    @Test
    public void testsina04(){
        //获取股票代码并分组
        //向url请求结果并处理数据
        //处理完的数据存入数据库

    }
}