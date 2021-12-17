package com.wyl.dict.gatewayimpl.database;

import com.wyl.dict.gatewayimpl.database.dataobject.SysConfig;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 参数配置表(SysConfig)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-17 16:08:49
 */
public interface SysConfigDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysConfig queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysConfig 实例对象
     * @return 对象列表
     */
    List<SysConfig> queryAll(SysConfig sysConfig);

    /**
     * 新增数据
     *
     * @param sysConfig 实例对象
     * @return 影响行数
     */
    int insert(SysConfig sysConfig);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysConfig> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysConfig> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysConfig> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysConfig> entities);

    /**
     * 修改数据
     *
     * @param sysConfig 实例对象
     * @return 影响行数
     */
    int update(SysConfig sysConfig);
    
    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long primaryKey);
    
}

