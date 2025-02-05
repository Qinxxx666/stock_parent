package org.qin.com.stock.service;

import org.qin.com.stock.entity.SysRolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色权限表(SysRolePermission)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:11
 */
public interface SysRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRolePermission queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysRolePermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SysRolePermission> queryByPage(SysRolePermission sysRolePermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    SysRolePermission insert(SysRolePermission sysRolePermission);

    /**
     * 修改数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    SysRolePermission update(SysRolePermission sysRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
