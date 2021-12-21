package com.wyl.upms.service;

import com.wyl.upms.gatewayimpl.database.dataobject.SysUserPost;
import com.wyl.upms.dto.clientobject.SysUserPostCO;
import com.wyl.upms.dto.qry.SysUserPostQry;
import com.wyl.upms.dto.qry.SysUserPostPageQry;
import com.wyl.upms.dto.command.SysUserPostAddCommand;
import com.wyl.upms.dto.command.SysUserPostEditCommand;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.MultiResponse;

import java.util.List;
import javax.validation.Valid;

/**
 * 用户与岗位关联表(SysUserPost)表服务接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:53
 */
public interface SysUserPostService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysUserPostCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysUserPostCO> queryAll(SysUserPostQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysUserPostCO> queryPage(SysUserPostPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysUserPostAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysUserPostEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

}
