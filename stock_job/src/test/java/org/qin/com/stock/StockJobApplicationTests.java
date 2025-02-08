package org.qin.com.stock;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.qin.com.stock.entity.StockMarketIndexInfo;
import org.qin.com.stock.utils.IdWorker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@SpringBootTest
@Slf4j
class StockJobApplicationTests {

//    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 测试get请求携带url参数，访问外部接口
     */
    @Test
    public void test01(){
        String url="http://localhost:6666/account/getByUserNameAndAddress?userName=itheima&address=shanghai";
        /*
          参数1：url请求地址
          参数2：请求返回的数据类型
         */
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        //获取响应头
        HttpHeaders headers = result.getHeaders();
        System.out.println(headers.toString());
        //响应状态码
        int statusCode = result.getStatusCodeValue();
        System.out.println(statusCode);
        //响应数据
        String respData = result.getBody();
        System.out.println(respData);
    }

    /**
     * 测试响应数据自动封装到vo对象
     */
    @Test
    public void test02(){
        String url="http://localhost:6666/account/getByUserNameAndAddress?userName=itheima&address=shanghai";
        /*
          参数1：url请求地址
          参数2：请求返回的数据类型
         */
        Account account = restTemplate.getForObject(url, Account.class);
        System.out.println(account);
    }

    @Data
    public static class Account {

        private Integer id;

        private String userName;

        private String address;

    }

    /**
     * 请求头设置参数，访问指定接口
     */
    @Test
    public void test03(){
        String url="http://localhost:6666/account/getHeader";
        //设置请求头参数
        HttpHeaders headers = new HttpHeaders();
        headers.add("userName","zhangsan");
        //请求头填充到请求对象下
        HttpEntity<Map> entry = new HttpEntity<>(headers);
        //发送请求
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entry, String.class);
        String result = responseEntity.getBody();
        System.out.println(result);
    }

    /**
     * post模拟form表单提交数据
     */
    @Test
    public void test04(){
        String url="http://localhost:6666/account/addAccount";
        //设置请求头，指定请求数据方式
        HttpHeaders headers = new HttpHeaders();
        //告知被调用方，请求方式是form表单提交，这样对方解析数据时，就会按照form表单的方式解析处理
        headers.add("Content-type","application/x-www-form-urlencoded");
        //组装模拟form表单提交数据，内部元素相当于form表单的input框
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("id","10");
        map.add("userName","itheima");
        map.add("address","shanghai");
        HttpEntity<LinkedMultiValueMap<String, Object>> httpEntity = new HttpEntity<>(map, headers);
        /*
            参数1：请求url地址
            参数2：请求方式 POST
            参数3：请求体对象，携带了请求头和请求体相关的参数
            参数4：响应数据类型
         */
        ResponseEntity<Account> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Account.class);
        Account body = exchange.getBody();
        System.out.println(body);
    }

    /**
     * post发送json数据
     */
    @Test
    public void test05(){
        String url="http://localhost:6666/account/updateAccount";
        //设置请求头的请求参数类型
        HttpHeaders headers = new HttpHeaders();
        //告知被调用方，发送的数据格式的json格式，对方要以json的方式解析处理
        headers.add("Content-type","application/json; charset=utf-8");
        //组装json格式数据
//        HashMap<String, String> reqMap = new HashMap<>();
//        reqMap.put("id","1");
//        reqMap.put("userName","zhangsan");
//        reqMap.put("address","上海");
//        String jsonReqData = new Gson().toJson(reqMap);
        String jsonReq="{\"address\":\"上海\",\"id\":\"1\",\"userName\":\"zhangsan\"}";
        //构建请求对象
        HttpEntity<String> httpEntity = new HttpEntity<>(jsonReq, headers);
          /*
            发送数据
            参数1：请求url地址
            参数2：请求方式
            参数3：请求体对象，携带了请求头和请求体相关的参数
            参数4：响应数据类型
         */
        ResponseEntity<Account> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Account.class);
        //或者
        // Account account=restTemplate.postForObject(url,httpEntity,Account.class);
        Account body = responseEntity.getBody();
        System.out.println(body);
    }

    /**
     * 获取请求cookie值
     */
    @Test
    public void test06(){
        String url="http://localhost:6666/account/getCookie";
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        //获取cookie
        List<String> cookies = result.getHeaders().get("Set-Cookie");
        //获取响应数据
        String resStr = result.getBody();
        System.out.println(resStr);
        System.out.println(cookies);
    }

    @Test
    public void testRep2(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

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
        log.info("当前采集的数据：{}",resString);
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

//            Date curTime = LocalDateTime.
//                    getDateTimeWithoutSecond
//                            (splitArr[30] + " " +
//                                    splitArr[31]).
//                    toDate();

            //组装entity对象
            IdWorker idWorker = new IdWorker();
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
            log.info(info.getCurTime().toString());
            list.add(info);
        }
        log.info("采集的当前大盘数据：{}",list);
        //批量插入
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
    }

}
