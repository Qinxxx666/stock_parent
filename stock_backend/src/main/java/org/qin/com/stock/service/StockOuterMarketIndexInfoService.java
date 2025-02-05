package org.qin.com.stock.service;

import org.qin.com.stock.entity.StockOuterMarketIndexInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 外盘详情信息表(StockOuterMarketIndexInfo)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
public interface StockOuterMarketIndexInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockOuterMarketIndexInfo queryById(Long id);

    /**
     * 分页查询
     *
     * @param stockOuterMarketIndexInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StockOuterMarketIndexInfo> queryByPage(StockOuterMarketIndexInfo stockOuterMarketIndexInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param stockOuterMarketIndexInfo 实例对象
     * @return 实例对象
     */
    StockOuterMarketIndexInfo insert(StockOuterMarketIndexInfo stockOuterMarketIndexInfo);

    /**
     * 修改数据
     *
     * @param stockOuterMarketIndexInfo 实例对象
     * @return 实例对象
     */
    StockOuterMarketIndexInfo update(StockOuterMarketIndexInfo stockOuterMarketIndexInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
