package org.qin.com.stock.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 主营业务表(StockBusiness)实体类
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public class StockBusiness implements Serializable {
    private static final long serialVersionUID = -97108018896783746L;
/**
     *  股票编码
     */
    private String stockCode;
/**
     * 股票名称
     */
    private String stockName;
/**
     * 股票所属行业|板块标识
     */
    private String blockLabel;
/**
     * 行业板块名称
     */
    private String blockName;
/**
     * 主营业务
     */
    private String business;
/**
     * 更新时间
     */
    private Date updateTime;


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

    public String getBlockLabel() {
        return blockLabel;
    }

    public void setBlockLabel(String blockLabel) {
        this.blockLabel = blockLabel;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

