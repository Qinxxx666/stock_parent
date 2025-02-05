package org.qin.com.stock.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 个股详情信息表(StockRtInfo)实体类
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
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
    private Double preClosePrice;
/**
     * 开盘价
     */
    private Double openPrice;
/**
     * 当前价格
     */
    private Double curPrice;
/**
     * 今日最低价
     */
    private Double minPrice;
/**
     * 今日最高价
     */
    private Double maxPrice;
/**
     * 成交量
     */
    private Long tradeAmount;
/**
     * 成交金额
     */
    private Double tradeVolume;
/**
     * 当前时间
     */
    private Date curTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getPreClosePrice() {
        return preClosePrice;
    }

    public void setPreClosePrice(Double preClosePrice) {
        this.preClosePrice = preClosePrice;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(Double curPrice) {
        this.curPrice = curPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Long getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Double getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(Double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public Date getCurTime() {
        return curTime;
    }

    public void setCurTime(Date curTime) {
        this.curTime = curTime;
    }

}

