package org.qin.com.stock.service.impl;

import org.qin.com.stock.entity.SysRolePermission;
import org.qin.com.stock.dao.SysRolePermissionDao;
import org.qin.com.stock.service.SysRolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 角色权限表(SysRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 23:30:11
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Resource
    private SysRolePermissionDao sysRolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRolePermission queryById(Long id) {
        return this.sysRolePermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysRolePermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysRolePermission> queryByPage(SysRolePermission sysRolePermission, PageRequest pageRequest) {
        long total = this.sysRolePermissionDao.count(sysRolePermission);
        return new PageImpl<>(this.sysRolePermissionDao.queryAllByLimit(sysRolePermission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysRolePermission insert(SysRolePermission sysRolePermission) {
        this.sysRolePermissionDao.insert(sysRolePermission);
        return sysRolePermission;
    }

    /**
     * 修改数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysRolePermission update(SysRolePermission sysRolePermission) {
        this.sysRolePermissionDao.update(sysRolePermission);
        return this.queryById(sysRolePermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysRolePermissionDao.deleteById(id) > 0;
    }
}
