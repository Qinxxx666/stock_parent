package org.qin.com.stock.entity;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 外盘详情信息表(StockOuterMarketIndexInfo)实体类
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
@Builder
public class StockOuterMarketIndexInfo implements Serializable {
    private static final long serialVersionUID = -41743017214611171L;
/**
     * 主键ID
     */
    private Long id;
/**
     * 大盘编码
     */
    private String marketCode;
/**
     * 大盘名称
     */
    private String marketName;
/**
     * 大盘当前点
     */
    private BigDecimal curPoint;
/**
     * 大盘涨跌值
     */
    private BigDecimal updown;
/**
     * 大盘涨幅
     */
    private BigDecimal rose;
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

    public BigDecimal getCurPoint() {
        return curPoint;
    }

    public void setCurPoint(BigDecimal curPoint) {
        this.curPoint = curPoint;
    }

    public BigDecimal getUpdown() {
        return updown;
    }

    public void setUpdown(BigDecimal updown) {
        this.updown = updown;
    }

    public BigDecimal getRose() {
        return rose;
    }

    public void setRose(BigDecimal rose) {
        this.rose = rose;
    }

    public Date getCurTime() {
        return curTime;
    }

    public void setCurTime(Date curTime) {
        this.curTime = curTime;
    }

}

