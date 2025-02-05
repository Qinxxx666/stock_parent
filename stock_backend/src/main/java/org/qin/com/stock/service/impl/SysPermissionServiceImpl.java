package org.qin.com.stock.service.impl;

import org.qin.com.stock.entity.SysPermission;
import org.qin.com.stock.dao.SysPermissionDao;
import org.qin.com.stock.service.SysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 权限表（菜单）(SysPermission)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 23:30:10
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionDao sysPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysPermission queryById(Long id) {
        return this.sysPermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysPermission> queryByPage(SysPermission sysPermission, PageRequest pageRequest) {
        long total = this.sysPermissionDao.count(sysPermission);
        return new PageImpl<>(this.sysPermissionDao.queryAllByLimit(sysPermission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermission insert(SysPermission sysPermission) {
        this.sysPermissionDao.insert(sysPermission);
        return sysPermission;
    }

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermission update(SysPermission sysPermission) {
        this.sysPermissionDao.update(sysPermission);
        return this.queryById(sysPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysPermissionDao.deleteById(id) > 0;
    }
}
