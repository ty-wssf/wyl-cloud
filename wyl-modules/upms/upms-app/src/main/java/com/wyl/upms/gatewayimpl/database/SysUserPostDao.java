package com.wyl.upms.gatewayimpl.database;

import com.wyl.upms.gatewayimpl.database.dataobject.SysUserPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户与岗位关联表(SysUserPost)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-21 13:22:51
 */
public interface SysUserPostDao {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysUserPost queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserPost 实例对象
     * @return 对象列表
     */
    List<SysUserPost> queryAll(SysUserPost sysUserPost);

    /**
     * 新增数据
     *
     * @param sysUserPost 实例对象
     * @return 影响行数
     */
    int insert(SysUserPost sysUserPost);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserPost> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUserPost> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserPost> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUserPost> entities);

    /**
     * 修改数据
     *
     * @param sysUserPost 实例对象
     * @return 影响行数
     */
    int update(SysUserPost sysUserPost);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long primaryKey);

}

