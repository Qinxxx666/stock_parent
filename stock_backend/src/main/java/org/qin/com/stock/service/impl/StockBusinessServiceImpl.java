package org.qin.com.stock.service.impl;

import org.qin.com.stock.entity.StockBusiness;
import org.qin.com.stock.dao.StockBusinessDao;
import org.qin.com.stock.service.StockBusinessService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 主营业务表(StockBusiness)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
@Service("stockBusinessService")
public class StockBusinessServiceImpl implements StockBusinessService {
    @Resource
    private StockBusinessDao stockBusinessDao;

    /**
     * 通过ID查询单条数据
     *
     * @param stockCode 主键
     * @return 实例对象
     */
    @Override
    public StockBusiness queryById(String stockCode) {
        return this.stockBusinessDao.queryById(stockCode);
    }

    /**
     * 分页查询
     *
     * @param stockBusiness 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StockBusiness> queryByPage(StockBusiness stockBusiness, PageRequest pageRequest) {
        long total = this.stockBusinessDao.count(stockBusiness);
        return new PageImpl<>(this.stockBusinessDao.queryAllByLimit(stockBusiness, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param stockBusiness 实例对象
     * @return 实例对象
     */
    @Override
    public StockBusiness insert(StockBusiness stockBusiness) {
        this.stockBusinessDao.insert(stockBusiness);
        return stockBusiness;
    }

    /**
     * 修改数据
     *
     * @param stockBusiness 实例对象
     * @return 实例对象
     */
    @Override
    public StockBusiness update(StockBusiness stockBusiness) {
        this.stockBusinessDao.update(stockBusiness);
        return this.queryById(stockBusiness.getStockCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param stockCode 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String stockCode) {
        return this.stockBusinessDao.deleteById(stockCode) > 0;
    }
}
