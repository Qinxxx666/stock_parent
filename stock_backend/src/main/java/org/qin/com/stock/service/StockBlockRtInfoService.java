package org.qin.com.stock.service;

import org.qin.com.stock.entity.StockBlockRtInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 股票板块详情信息表(StockBlockRtInfo)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
public interface StockBlockRtInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockBlockRtInfo queryById(Long id);

    /**
     * 分页查询
     *
     * @param stockBlockRtInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StockBlockRtInfo> queryByPage(StockBlockRtInfo stockBlockRtInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param stockBlockRtInfo 实例对象
     * @return 实例对象
     */
    StockBlockRtInfo insert(StockBlockRtInfo stockBlockRtInfo);

    /**
     * 修改数据
     *
     * @param stockBlockRtInfo 实例对象
     * @return 实例对象
     */
    StockBlockRtInfo update(StockBlockRtInfo stockBlockRtInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
