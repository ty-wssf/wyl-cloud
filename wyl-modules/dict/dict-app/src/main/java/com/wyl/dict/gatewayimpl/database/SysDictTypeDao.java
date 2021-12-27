package com.wyl.dict.gatewayimpl.database;

import com.wyl.dict.gatewayimpl.database.dataobject.SysDictType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典类型表(SysDictType)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-17 21:12:14
 */
public interface SysDictTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysDictType queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDictType 实例对象
     * @return 对象列表
     */
    List<SysDictType> queryAll(SysDictType sysDictType);

    /**
     * 新增数据
     *
     * @param sysDictType 实例对象
     * @return 影响行数
     */
    int insert(SysDictType sysDictType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysDictType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysDictType> entities);

    /**
     * 修改数据
     *
     * @param sysDictType 实例对象
     * @return 影响行数
     */
    int update(SysDictType sysDictType);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long primaryKey);

    /**
     * 通过字典类型查询
     *
     * @param dictType
     * @return
     */
    SysDictType queryByDictType(String dictType);

}

