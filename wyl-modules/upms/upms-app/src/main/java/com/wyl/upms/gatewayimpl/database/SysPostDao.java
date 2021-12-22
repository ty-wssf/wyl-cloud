package com.wyl.upms.gatewayimpl.database;

import com.wyl.upms.gatewayimpl.database.dataobject.SysPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 岗位信息表(SysPost)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-21 09:48:14
 */
public interface SysPostDao {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysPost queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPost 实例对象
     * @return 对象列表
     */
    List<SysPost> queryAll(SysPost sysPost);

    /**
     * 新增数据
     *
     * @param sysPost 实例对象
     * @return 影响行数
     */
    int insert(SysPost sysPost);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysPost> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysPost> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysPost> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysPost> entities);

    /**
     * 修改数据
     *
     * @param sysPost 实例对象
     * @return 影响行数
     */
    int update(SysPost sysPost);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long primaryKey);

    List<SysPost> queryPostsByUserId(@Param("userId") Long userId);

}

