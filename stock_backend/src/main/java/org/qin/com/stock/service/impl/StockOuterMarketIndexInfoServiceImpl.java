package org.qin.com.stock.service.impl;

import org.qin.com.stock.entity.StockOuterMarketIndexInfo;
import org.qin.com.stock.dao.StockOuterMarketIndexInfoDao;
import org.qin.com.stock.service.StockOuterMarketIndexInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 外盘详情信息表(StockOuterMarketIndexInfo)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
@Service("stockOuterMarketIndexInfoService")
public class StockOuterMarketIndexInfoServiceImpl implements StockOuterMarketIndexInfoService {
    @Resource
    private StockOuterMarketIndexInfoDao stockOuterMarketIndexInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockOuterMarketIndexInfo queryById(Long id) {
        return this.stockOuterMarketIndexInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param stockOuterMarketIndexInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StockOuterMarketIndexInfo> queryByPage(StockOuterMarketIndexInfo stockOuterMarketIndexInfo, PageRequest pageRequest) {
        long total = this.stockOuterMarketIndexInfoDao.count(stockOuterMarketIndexInfo);
        return new PageImpl<>(this.stockOuterMarketIndexInfoDao.queryAllByLimit(stockOuterMarketIndexInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param stockOuterMarketIndexInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StockOuterMarketIndexInfo insert(StockOuterMarketIndexInfo stockOuterMarketIndexInfo) {
        this.stockOuterMarketIndexInfoDao.insert(stockOuterMarketIndexInfo);
        return stockOuterMarketIndexInfo;
    }

    /**
     * 修改数据
     *
     * @param stockOuterMarketIndexInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StockOuterMarketIndexInfo update(StockOuterMarketIndexInfo stockOuterMarketIndexInfo) {
        this.stockOuterMarketIndexInfoDao.update(stockOuterMarketIndexInfo);
        return this.queryById(stockOuterMarketIndexInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.stockOuterMarketIndexInfoDao.deleteById(id) > 0;
    }
}
