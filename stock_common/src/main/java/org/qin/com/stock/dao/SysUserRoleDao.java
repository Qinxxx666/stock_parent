package org.qin.com.stock.dao;

import org.qin.com.stock.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 用户角色表(SysUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public interface SysUserRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserRole queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param sysUserRole 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SysUserRole> queryAllByLimit(SysUserRole sysUserRole, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sysUserRole 查询条件
     * @return 总行数
     */
    long count(SysUserRole sysUserRole);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    int insert(SysUserRole sysUserRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUserRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUserRole> entities);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    int update(SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

