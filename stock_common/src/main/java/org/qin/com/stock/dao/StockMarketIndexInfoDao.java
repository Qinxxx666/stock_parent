package org.qin.com.stock.dao;

import org.qin.com.stock.entity.StockMarketIndexInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 国内大盘数据详情表(StockMarketIndexInfo)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public interface StockMarketIndexInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockMarketIndexInfo queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param stockMarketIndexInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<StockMarketIndexInfo> queryAllByLimit(StockMarketIndexInfo stockMarketIndexInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param stockMarketIndexInfo 查询条件
     * @return 总行数
     */
    long count(StockMarketIndexInfo stockMarketIndexInfo);

    /**
     * 新增数据
     *
     * @param stockMarketIndexInfo 实例对象
     * @return 影响行数
     */
    int insert(StockMarketIndexInfo stockMarketIndexInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockMarketIndexInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StockMarketIndexInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StockMarketIndexInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StockMarketIndexInfo> entities);

    /**
     * 修改数据
     *
     * @param stockMarketIndexInfo 实例对象
     * @return 影响行数
     */
    int update(StockMarketIndexInfo stockMarketIndexInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

