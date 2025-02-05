package org.qin.com.stock.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 股票板块详情信息表(StockBlockRtInfo)实体类
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public class StockBlockRtInfo implements Serializable {
    private static final long serialVersionUID = 439006071654687496L;
/**
     * 板块主键ID（业务无关）
     */
    private Long id;
/**
     * 表示，如：new_blhy-玻璃行业
     */
    private String label;
/**
     * 板块名称
     */
    private String blockName;
/**
     * 公司数量
     */
    private Integer companyNum;
/**
     * 平均价格
     */
    private Double avgPrice;
/**
     * 涨跌幅
     */
    private Double updownRate;
/**
     * 交易量
     */
    private Long tradeAmount;
/**
     * 交易金额
     */
    private Double tradeVolume;
/**
     * 当前日期（精确到秒）
     */
    private Date curTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Integer getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(Integer companyNum) {
        this.companyNum = companyNum;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Double getUpdownRate() {
        return updownRate;
    }

    public void setUpdownRate(Double updownRate) {
        this.updownRate = updownRate;
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

