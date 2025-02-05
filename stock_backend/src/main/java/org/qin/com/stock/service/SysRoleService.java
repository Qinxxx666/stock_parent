package org.qin.com.stock.service;

import org.qin.com.stock.entity.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色表(SysRole)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:11
 */
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRole queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SysRole> queryByPage(SysRole sysRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole insert(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
