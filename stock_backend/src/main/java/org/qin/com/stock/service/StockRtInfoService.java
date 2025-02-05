package org.qin.com.stock.service;

import org.qin.com.stock.entity.StockRtInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 个股详情信息表(StockRtInfo)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
public interface StockRtInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockRtInfo queryById(Long id);

    /**
     * 分页查询
     *
     * @param stockRtInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StockRtInfo> queryByPage(StockRtInfo stockRtInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param stockRtInfo 实例对象
     * @return 实例对象
     */
    StockRtInfo insert(StockRtInfo stockRtInfo);

    /**
     * 修改数据
     *
     * @param stockRtInfo 实例对象
     * @return 实例对象
     */
    StockRtInfo update(StockRtInfo stockRtInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
