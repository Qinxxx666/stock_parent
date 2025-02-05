package org.qin.com.stock.service;

import org.qin.com.stock.entity.SysPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 权限表（菜单）(SysPermission)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
public interface SysPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermission queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SysPermission> queryByPage(SysPermission sysPermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    SysPermission insert(SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    SysPermission update(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
