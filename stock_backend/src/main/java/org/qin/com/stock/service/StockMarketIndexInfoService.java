package org.qin.com.stock.service;

import org.qin.com.stock.entity.StockMarketIndexInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 国内大盘数据详情表(StockMarketIndexInfo)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
public interface StockMarketIndexInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockMarketIndexInfo queryById(Long id);

    /**
     * 分页查询
     *
     * @param stockMarketIndexInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StockMarketIndexInfo> queryByPage(StockMarketIndexInfo stockMarketIndexInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param stockMarketIndexInfo 实例对象
     * @return 实例对象
     */
    StockMarketIndexInfo insert(StockMarketIndexInfo stockMarketIndexInfo);

    /**
     * 修改数据
     *
     * @param stockMarketIndexInfo 实例对象
     * @return 实例对象
     */
    StockMarketIndexInfo update(StockMarketIndexInfo stockMarketIndexInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
