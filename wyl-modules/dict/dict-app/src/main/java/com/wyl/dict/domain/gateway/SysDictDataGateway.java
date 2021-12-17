package com.wyl.dict.domain.gateway;

import com.wyl.dict.gatewayimpl.database.dataobject.SysDictData;
import cn.wyl.common.core.dto.PageResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典数据表(SysDictData)表网关接口
 *
 * @author wyl
 * @since 2021-12-17 21:35:55
 */
public interface SysDictDataGateway {

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
     * 查询单条数据
     *
     * @param sysDictData 实例对象
     * @return
     */
    SysDictData queryOne(SysDictData sysDictData);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDictData 实例对象
     * @return 对象列表
     */
    PageResponse<SysDictData> queryPage(SysDictData sysDictData);

    /**
     * 新增数据
     *
     * @param sysDictData 实例对象
     * @return 影响行数
     */
    void insert(SysDictData sysDictData);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictData> 实例对象列表
     * @return 影响行数
     */
    void insertBatch(@Param("entities") List<SysDictData> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictData> 实例对象列表
     * @return 影响行数
     */
    void insertOrUpdateBatch(@Param("entities") List<SysDictData> entities);

    /**
     * 修改数据
     *
     * @param sysDictData 实例对象
     * @return 影响行数
     */
    void update(SysDictData sysDictData);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    void deleteByPrimaryKey(Long primaryKey);

}

