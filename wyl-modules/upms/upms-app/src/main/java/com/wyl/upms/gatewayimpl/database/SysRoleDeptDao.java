package com.wyl.upms.gatewayimpl.database;

import com.wyl.upms.gatewayimpl.database.dataobject.SysRoleDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色和部门关联表(SysRoleDept)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-21 13:22:39
 */
public interface SysRoleDeptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysRoleDept queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleDept 实例对象
     * @return 对象列表
     */
    List<SysRoleDept> queryAll(SysRoleDept sysRoleDept);

    /**
     * 新增数据
     *
     * @param sysRoleDept 实例对象
     * @return 影响行数
     */
    int insert(SysRoleDept sysRoleDept);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleDept> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysRoleDept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleDept> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysRoleDept> entities);

    /**
     * 修改数据
     *
     * @param sysRoleDept 实例对象
     * @return 影响行数
     */
    int update(SysRoleDept sysRoleDept);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long primaryKey);

}

