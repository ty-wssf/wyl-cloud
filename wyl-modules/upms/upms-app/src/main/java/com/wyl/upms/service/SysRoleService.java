package com.wyl.upms.service;

import com.wyl.upms.gatewayimpl.database.dataobject.SysRole;
import com.wyl.upms.dto.clientobject.SysRoleCO;
import com.wyl.upms.dto.qry.SysRoleQry;
import com.wyl.upms.dto.qry.SysRolePageQry;
import com.wyl.upms.dto.command.SysRoleAddCommand;
import com.wyl.upms.dto.command.SysRoleEditCommand;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.MultiResponse;

import java.util.List;
import javax.validation.Valid;

/**
 * 角色信息表(SysRole)表服务接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:37
 */
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysRoleCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysRoleCO> queryAll(SysRoleQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysRoleCO> queryPage(SysRolePageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysRoleAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysRoleEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

}
