package org.qin.com.stock.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Title: TimeUtil
 * @Author Qin
 * @Package org.qin.com.stock.utils
 * @Version
 * @Date 2025/2/7 14:31
 * @description:
 */
public class TimeUtil {
    public static Date nowWithoutSec(){
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.withSecond(0).withNano(0);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    public static Date parse(String data, String time){
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 解析日期时间字符串
        LocalDateTime dateTime = LocalDateTime.parse(data + " " + time, formatter);
        // 去掉秒和纳秒
        LocalDateTime dateTimeWithoutSeconds = dateTime.withSecond(0).withNano(0);
        // 转换为 Date
        return Date.from(dateTimeWithoutSeconds.atZone(ZoneId.systemDefault()).toInstant());
    }
}
