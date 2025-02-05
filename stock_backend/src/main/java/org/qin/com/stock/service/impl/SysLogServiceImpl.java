package org.qin.com.stock.service.impl;

import org.qin.com.stock.entity.SysLog;
import org.qin.com.stock.dao.SysLogDao;
import org.qin.com.stock.service.SysLogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 系统日志(SysLog)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SysLogDao sysLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysLog queryById(Long id) {
        return this.sysLogDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysLog> queryByPage(SysLog sysLog, PageRequest pageRequest) {
        long total = this.sysLogDao.count(sysLog);
        return new PageImpl<>(this.sysLogDao.queryAllByLimit(sysLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysLog 实例对象
     * @return 实例对象
     */
    @Override
    public SysLog insert(SysLog sysLog) {
        this.sysLogDao.insert(sysLog);
        return sysLog;
    }

    /**
     * 修改数据
     *
     * @param sysLog 实例对象
     * @return 实例对象
     */
    @Override
    public SysLog update(SysLog sysLog) {
        this.sysLogDao.update(sysLog);
        return this.queryById(sysLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysLogDao.deleteById(id) > 0;
    }
}
