package org.qin.com.stock.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * @Title: HttpUtil
 * @Author Qin
 * @Package org.qin.com.stock.utils
 * @Version
 * @Date 2025/2/7 10:26
 * @description:
 */
public class HttpUtil {
    public static String get(String url) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        //必须填写，否则数据采集不到
        headers.add("Referer","https://finance.sina.com.cn/stock/");
        headers.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
        //2.2 组装请求对象
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        //2.3 resetTemplate发起请求
        String resString = restTemplate.postForObject(url, entity, String.class);
        return resString;
    }
}