package org.qin.com.stock.service.impl;

import org.qin.com.stock.entity.StockMarketIndexInfo;
import org.qin.com.stock.dao.StockMarketIndexInfoDao;
import org.qin.com.stock.service.StockMarketIndexInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 国内大盘数据详情表(StockMarketIndexInfo)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
@Service("stockMarketIndexInfoService")
public class StockMarketIndexInfoServiceImpl implements StockMarketIndexInfoService {
    @Resource
    private StockMarketIndexInfoDao stockMarketIndexInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockMarketIndexInfo queryById(Long id) {
        return this.stockMarketIndexInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param stockMarketIndexInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StockMarketIndexInfo> queryByPage(StockMarketIndexInfo stockMarketIndexInfo, PageRequest pageRequest) {
        long total = this.stockMarketIndexInfoDao.count(stockMarketIndexInfo);
        return new PageImpl<>(this.stockMarketIndexInfoDao.queryAllByLimit(stockMarketIndexInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param stockMarketIndexInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StockMarketIndexInfo insert(StockMarketIndexInfo stockMarketIndexInfo) {
        this.stockMarketIndexInfoDao.insert(stockMarketIndexInfo);
        return stockMarketIndexInfo;
    }

    /**
     * 修改数据
     *
     * @param stockMarketIndexInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StockMarketIndexInfo update(StockMarketIndexInfo stockMarketIndexInfo) {
        this.stockMarketIndexInfoDao.update(stockMarketIndexInfo);
        return this.queryById(stockMarketIndexInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.stockMarketIndexInfoDao.deleteById(id) > 0;
    }
}
