package org.qin.com.stock.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 个股详情信息表(StockRtInfo)实体类
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
@Setter
@Getter
@Builder
public class StockRtInfo implements Serializable {
    private static final long serialVersionUID = 403896015127065870L;
/**
     * 主键字段（无业务意义）
     */
    private Long id;
/**
     * 股票代码
     */
    private String stockCode;
/**
     * 股票名称
     */
    private String stockName;
/**
     * 前收盘价| 昨日收盘价
     */
    private BigDecimal preClosePrice;
/**
     * 开盘价
     */
    private BigDecimal openPrice;
/**
     * 当前价格
     */
    private BigDecimal curPrice;
/**
     * 今日最低价
     */
    private BigDecimal minPrice;
/**
     * 今日最高价
     */
    private BigDecimal maxPrice;
/**
     * 成交量
     */
    private Long tradeAmount;
/**
     * 成交金额
     */
    private BigDecimal tradeVolume;
/**
     * 当前时间
     */
    private Date curTime;


}

