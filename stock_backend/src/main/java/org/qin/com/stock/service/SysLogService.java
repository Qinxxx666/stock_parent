package org.qin.com.stock.service;

import org.qin.com.stock.entity.SysLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 系统日志(SysLog)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
public interface SysLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysLog queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SysLog> queryByPage(SysLog sysLog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysLog 实例对象
     * @return 实例对象
     */
    SysLog insert(SysLog sysLog);

    /**
     * 修改数据
     *
     * @param sysLog 实例对象
     * @return 实例对象
     */
    SysLog update(SysLog sysLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
