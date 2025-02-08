package org.qin.com.stock.utils;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    public Date nowWithoutSec(){
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.withSecond(0).withNano(0);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
