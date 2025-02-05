package org.qin.com.stock.service.impl;

import org.qin.com.stock.entity.SysRole;
import org.qin.com.stock.dao.SysRoleDao;
import org.qin.com.stock.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 角色表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2025-01-26 23:30:11
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRole queryById(Long id) {
        return this.sysRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysRole> queryByPage(SysRole sysRole, PageRequest pageRequest) {
        long total = this.sysRoleDao.count(sysRole);
        return new PageImpl<>(this.sysRoleDao.queryAllByLimit(sysRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole insert(SysRole sysRole) {
        this.sysRoleDao.insert(sysRole);
        return sysRole;
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole update(SysRole sysRole) {
        this.sysRoleDao.update(sysRole);
        return this.queryById(sysRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysRoleDao.deleteById(id) > 0;
    }
}
