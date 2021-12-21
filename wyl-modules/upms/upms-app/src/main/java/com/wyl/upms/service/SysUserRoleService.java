package com.wyl.upms.service;

import com.wyl.upms.gatewayimpl.database.dataobject.SysUserRole;
import com.wyl.upms.dto.clientobject.SysUserRoleCO;
import com.wyl.upms.dto.qry.SysUserRoleQry;
import com.wyl.upms.dto.qry.SysUserRolePageQry;
import com.wyl.upms.dto.command.SysUserRoleAddCommand;
import com.wyl.upms.dto.command.SysUserRoleEditCommand;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.MultiResponse;

import java.util.List;
import javax.validation.Valid;

/**
 * 用户和角色关联表(SysUserRole)表服务接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:54
 */
public interface SysUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysUserRoleCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysUserRoleCO> queryAll(SysUserRoleQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysUserRoleCO> queryPage(SysUserRolePageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysUserRoleAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysUserRoleEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

}
