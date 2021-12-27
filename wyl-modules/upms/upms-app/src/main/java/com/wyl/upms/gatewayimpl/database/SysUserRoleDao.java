package com.wyl.upms.gatewayimpl.database;

import com.wyl.upms.gatewayimpl.database.dataobject.SysUserRole;

import java.util.List;

/**
 * 用户和角色关联表(SysUserRole)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-21 13:22:53
 */
public interface SysUserRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysUserRole queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserRole 实例对象
     * @return 对象列表
     */
    List<SysUserRole> queryAll(SysUserRole sysUserRole);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    int insert(SysUserRole sysUserRole);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    int update(SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long primaryKey);

    /**
     * 删除用户与角色关联
     *
     * @param userId
     */
    void deleteUserRoleByUserId(Long userId);

}

