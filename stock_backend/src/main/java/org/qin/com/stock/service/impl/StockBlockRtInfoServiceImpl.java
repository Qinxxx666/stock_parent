package org.qin.com.stock.service.impl;

import org.qin.com.stock.entity.StockBlockRtInfo;
import org.qin.com.stock.dao.StockBlockRtInfoDao;
import org.qin.com.stock.service.StockBlockRtInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 股票板块详情信息表(StockBlockRtInfo)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
@Service("stockBlockRtInfoService")
public class StockBlockRtInfoServiceImpl implements StockBlockRtInfoService {
    @Resource
    private StockBlockRtInfoDao stockBlockRtInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StockBlockRtInfo queryById(Long id) {
        return this.stockBlockRtInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param stockBlockRtInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StockBlockRtInfo> queryByPage(StockBlockRtInfo stockBlockRtInfo, PageRequest pageRequest) {
        long total = this.stockBlockRtInfoDao.count(stockBlockRtInfo);
        return new PageImpl<>(this.stockBlockRtInfoDao.queryAllByLimit(stockBlockRtInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param stockBlockRtInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StockBlockRtInfo insert(StockBlockRtInfo stockBlockRtInfo) {
        this.stockBlockRtInfoDao.insert(stockBlockRtInfo);
        return stockBlockRtInfo;
    }

    /**
     * 修改数据
     *
     * @param stockBlockRtInfo 实例对象
     * @return 实例对象
     */
    @Override
    public StockBlockRtInfo update(StockBlockRtInfo stockBlockRtInfo) {
        this.stockBlockRtInfoDao.update(stockBlockRtInfo);
        return this.queryById(stockBlockRtInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.stockBlockRtInfoDao.deleteById(id) > 0;
    }
}
