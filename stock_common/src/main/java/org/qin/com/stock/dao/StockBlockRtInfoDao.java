package org.qin.com.stock.dao;

import org.qin.com.stock.entity.StockBlockRtInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 股票板块详情信息表(StockBlockRtInfo)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public interface StockBlockRtInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockBlockRtInfo queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param stockBlockRtInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<StockBlockRtInfo> queryAllByLimit(StockBlockRtInfo stockBlockRtInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param stockBlockRtInfo 查询条件
     * @return 总行数
     */
    long count(StockBlockRtInfo stockBlockRtInfo);

    /**
     * 新增数据
     *
     * @param stockBlockRtInfo 实例对象
     * @return 影响行数
     */
    int insert(StockBlockRtInfo stockBlockRtInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockBlockRtInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StockBlockRtInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockBlockRtInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StockBlockRtInfo> entities);

    /**
     * 修改数据
     *
     * @param stockBlockRtInfo 实例对象
     * @return 影响行数
     */
    int update(StockBlockRtInfo stockBlockRtInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

