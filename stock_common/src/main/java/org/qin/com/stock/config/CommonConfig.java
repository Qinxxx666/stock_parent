package org.qin.com.stock.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.qin.com.stock.utils.IdWorker;
import org.qin.com.stock.utils.ParserStockInfoUtil;
import org.qin.com.stock.utils.TimeUtil;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Title: CommonConfig
 * @Author Qin
 * @Package org.qin.com.stock.config
 * @Version
 * @Date 2025/2/7 14:15
 * @description:
 */
@EnableConfigurationProperties(StockInfoConfig.class)//开启常用参数配置bean
@Configuration
public class CommonConfig {
    /**
     * 密码加密器
     * BCryptPasswordEncoder方法采用SHA-256对密码进行加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置id生成器bean
     * @return
     */
    @Bean
    public IdWorker idWorker(){
        //基于运维人员对机房和机器的编号规划自行约定
        return new IdWorker(1L, 2L);
    }

    //......
    /**
     * 配置解析工具bean
     * @param idWorker
     * @return
     */
    @Bean
    public ParserStockInfoUtil parserStockInfoUtil(IdWorker idWorker){
        return new ParserStockInfoUtil(idWorker);
    }

    @Bean
    public TimeUtil timeUtil(){
        return new TimeUtil();
    }
    /**
     * 构建缓存bean
     * @return
     */
    @Bean
    public Cache<String,Object> caffeineCache(){
        Cache<String, Object> cache = Caffeine
                .newBuilder()
                .maximumSize(200)//设置缓存数量上限
//                .expireAfterAccess(1, TimeUnit.SECONDS)//访问1秒后删除
//                .expireAfterWrite(1,TimeUnit.SECONDS)//写入1秒后删除
                .initialCapacity(100)// 初始的缓存空间大小
                .recordStats()//开启统计
                .build();
        return cache;
    }
}
