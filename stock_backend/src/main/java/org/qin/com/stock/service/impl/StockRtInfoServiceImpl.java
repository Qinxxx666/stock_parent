package org.qin.com.stock.service.impl;

import org.qin.com.stock.entity.StockRtInfo;
import org.qin.com.stock.dao.StockRtInfoDao;
import org.qin.com.stock.service.StockRtInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 个股详情信息表(StockRtInfo)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
@Service("stockRtInfoService")
public class StockRtInfoServiceImpl implements StockRtInfoService {
    @Resource
    private StockRtInfoDao stockRtInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockRtInfo queryById(Long id) {
        return this.stockRtInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param stockRtInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StockRtInfo> queryByPage(StockRtInfo stockRtInfo, PageRequest pageRequest) {
        long total = this.stockRtInfoDao.count(stockRtInfo);
        return new PageImpl<>(this.stockRtInfoDao.queryAllByLimit(stockRtInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param stockRtInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StockRtInfo insert(StockRtInfo stockRtInfo) {
        this.stockRtInfoDao.insert(stockRtInfo);
        return stockRtInfo;
    }

    /**
     * 修改数据
     *
     * @param stockRtInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StockRtInfo update(StockRtInfo stockRtInfo) {
        this.stockRtInfoDao.update(stockRtInfo);
        return this.queryById(stockRtInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.stockRtInfoDao.deleteById(id) > 0;
    }
}
