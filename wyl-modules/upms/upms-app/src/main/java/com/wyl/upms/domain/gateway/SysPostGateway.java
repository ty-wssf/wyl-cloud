package com.wyl.upms.domain.gateway;

import com.wyl.upms.gatewayimpl.database.dataobject.SysPost;
import cn.wyl.common.core.dto.PageResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 岗位信息表(SysPost)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 09:48:14
 */
public interface SysPostGateway {

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
     * 查询单条数据
     *
     * @param sysPost 实例对象
     * @return
     */
    SysPost queryOne(SysPost sysPost);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPost 实例对象
     * @return 对象列表
     */
    PageResponse<SysPost> queryPage(SysPost sysPost);

    /**
     * 新增数据
     *
     * @param sysPost 实例对象
     * @return 影响行数
     */
    void insert(SysPost sysPost);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysPost> 实例对象列表
     * @return 影响行数
     */
    void insertBatch(@Param("entities") List<SysPost> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysPost> 实例对象列表
     * @return 影响行数
     */
    void insertOrUpdateBatch(@Param("entities") List<SysPost> entities);

    /**
     * 修改数据
     *
     * @param sysPost 实例对象
     * @return 影响行数
     */
    void update(SysPost sysPost);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    void deleteByPrimaryKey(Long primaryKey);

}

