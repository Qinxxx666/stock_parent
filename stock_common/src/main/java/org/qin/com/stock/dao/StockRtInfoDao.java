package org.qin.com.stock.dao;

import org.qin.com.stock.entity.StockRtInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 个股详情信息表(StockRtInfo)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public interface StockRtInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockRtInfo queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param stockRtInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<StockRtInfo> queryAllByLimit(StockRtInfo stockRtInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param stockRtInfo 查询条件
     * @return 总行数
     */
    long count(StockRtInfo stockRtInfo);

    /**
     * 新增数据
     *
     * @param stockRtInfo 实例对象
     * @return 影响行数
     */
    int insert(StockRtInfo stockRtInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockRtInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StockRtInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockRtInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StockRtInfo> entities);

    /**
     * 修改数据
     *
     * @param stockRtInfo 实例对象
     * @return 影响行数
     */
    int update(StockRtInfo stockRtInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

