package org.qin.com.stock.service;

import org.qin.com.stock.entity.StockBusiness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 主营业务表(StockBusiness)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
public interface StockBusinessService {

    /**
     * 通过ID查询单条数据
     *
     * @param stockCode 主键
     * @return 实例对象
     */
    StockBusiness queryById(String stockCode);

    /**
     * 分页查询
     *
     * @param stockBusiness 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StockBusiness> queryByPage(StockBusiness stockBusiness, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param stockBusiness 实例对象
     * @return 实例对象
     */
    StockBusiness insert(StockBusiness stockBusiness);

    /**
     * 修改数据
     *
     * @param stockBusiness 实例对象
     * @return 实例对象
     */
    StockBusiness update(StockBusiness stockBusiness);

    /**
     * 通过主键删除数据
     *
     * @param stockCode 主键
     * @return 是否成功
     */
    boolean deleteById(String stockCode);

}
