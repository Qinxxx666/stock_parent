package org.qin.com.stock.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Title: StockInfoConfig
 * @Author Qin
 * @Package org.qin.com.stock.config
 * @Version
 * @Date 2025/2/7 14:13
 * @description:
 */
@ConfigurationProperties(prefix = "stock")
@Data
public class StockInfoConfig {
    //a股大盘ID集合
    private List<String> inner;
    //外盘ID集合
    private List<String> outer;
    //大盘参数获取url
    private String marketUrl;
    //板块参数获取url
    private String blockUrl;
}
