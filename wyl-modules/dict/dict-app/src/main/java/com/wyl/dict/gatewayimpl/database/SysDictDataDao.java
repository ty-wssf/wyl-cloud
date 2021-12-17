package com.wyl.dict.gatewayimpl.database;

import com.wyl.dict.gatewayimpl.database.dataobject.SysDictData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典数据表(SysDictData)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-17 21:35:55
 */
public interface SysDictDataDao {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysDictData queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDictData 实例对象
     * @return 对象列表
     */
    List<SysDictData> queryAll(SysDictData sysDictData);

    /**
     * 新增数据
     *
     * @param sysDictData 实例对象
     * @return 影响行数
     */
    int insert(SysDictData sysDictData);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictData> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysDictData> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictData> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysDictData> entities);

    /**
     * 修改数据
     *
     * @param sysDictData 实例对象
     * @return 影响行数
     */
    int update(SysDictData sysDictData);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long primaryKey);

}

