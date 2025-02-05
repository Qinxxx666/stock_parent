package org.qin.com.stock.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 国内大盘数据详情表(StockMarketIndexInfo)实体类
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public class StockMarketIndexInfo implements Serializable {
    private static final long serialVersionUID = 370167967461924224L;
/**
     * 主键字段（无业务意义）
     */
    private Long id;
/**
     * 大盘编码
     */
    private String marketCode;
/**
     * 指数名称
     */
    private String marketName;
/**
     * 前收盘点数
     */
    private Double preClosePoint;
/**
     * 开盘点数
     */
    private Double openPoint;
/**
     * 当前点数
     */
    private Double curPoint;
/**
     * 最低点数
     */
    private Double minPoint;
/**
     * 最高点数
     */
    private Double maxPoint;
/**
     * 成交量(手)
     */
    private Long tradeAmount;
/**
     * 成交金额（元）
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

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Double getPreClosePoint() {
        return preClosePoint;
    }

    public void setPreClosePoint(Double preClosePoint) {
        this.preClosePoint = preClosePoint;
    }

    public Double getOpenPoint() {
        return openPoint;
    }

    public void setOpenPoint(Double openPoint) {
        this.openPoint = openPoint;
    }

    public Double getCurPoint() {
        return curPoint;
    }

    public void setCurPoint(Double curPoint) {
        this.curPoint = curPoint;
    }

    public Double getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(Double minPoint) {
        this.minPoint = minPoint;
    }

    public Double getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
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

