package org.qin.com.stock.service;

import org.qin.com.stock.entity.SysUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户角色表(SysUserRole)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:11
 */
public interface SysUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserRole queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysUserRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SysUserRole> queryByPage(SysUserRole sysUserRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    SysUserRole insert(SysUserRole sysUserRole);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    SysUserRole update(SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
