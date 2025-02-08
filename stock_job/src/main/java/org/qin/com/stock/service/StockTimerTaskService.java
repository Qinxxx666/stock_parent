package org.qin.com.stock.service;

/**
 * @Title: StockTimerTaskService
 * @Author Qin
 * @Package org.qin.com.stock.service
 * @Version
 * @Date 2025/2/7 14:19
 * @description:
 */
public interface StockTimerTaskService {
    public void getInnerMarketInfo();
    public void getOuterMarketInfo();
    public void getStockInfo();
    public void getBlockInfo();
}
