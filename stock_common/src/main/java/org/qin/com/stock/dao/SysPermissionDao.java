package org.qin.com.stock.dao;

import org.qin.com.stock.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 权限表（菜单）(SysPermission)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public interface SysPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermission queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param sysPermission 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SysPermission> queryAllByLimit(SysPermission sysPermission, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sysPermission 查询条件
     * @return 总行数
     */
    long count(SysPermission sysPermission);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    int insert(SysPermission sysPermission);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysPermission> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysPermission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysPermission> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysPermission> entities);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    int update(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

