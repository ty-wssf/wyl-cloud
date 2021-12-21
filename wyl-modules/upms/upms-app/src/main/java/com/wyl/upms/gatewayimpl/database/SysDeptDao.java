package com.wyl.upms.gatewayimpl.database;

import com.wyl.upms.gatewayimpl.database.dataobject.SysDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门表(SysDept)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-20 16:10:10
 */
public interface SysDeptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysDept queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDept 实例对象
     * @return 对象列表
     */
    List<SysDept> queryAll(SysDept sysDept);

    /**
     * 新增数据
     *
     * @param sysDept 实例对象
     * @return 影响行数
     */
    int insert(SysDept sysDept);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDept> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysDept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDept> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysDept> entities);

    /**
     * 修改数据
     *
     * @param sysDept 实例对象
     * @return 影响行数
     */
    int update(SysDept sysDept);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long primaryKey);

}

