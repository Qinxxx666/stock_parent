package org.qin.com.stock.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 股票板块详情信息表(StockBlockRtInfo)实体类
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
//@Setter
//@Getter
@Setter
@Getter
@Builder
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
    private BigDecimal avgPrice;
/**
     * 涨跌幅
     */
    private BigDecimal updownRate;
/**
     * 交易量
     */
    private Long tradeAmount;
/**
     * 交易金额
     */
    private BigDecimal tradeVolume;
/**
     * 当前日期（精确到秒）
     */
    private Date curTime;


}

