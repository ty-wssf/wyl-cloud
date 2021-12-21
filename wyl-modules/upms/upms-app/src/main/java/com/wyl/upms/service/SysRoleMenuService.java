package com.wyl.upms.service;

import com.wyl.upms.gatewayimpl.database.dataobject.SysRoleMenu;
import com.wyl.upms.dto.clientobject.SysRoleMenuCO;
import com.wyl.upms.dto.qry.SysRoleMenuQry;
import com.wyl.upms.dto.qry.SysRoleMenuPageQry;
import com.wyl.upms.dto.command.SysRoleMenuAddCommand;
import com.wyl.upms.dto.command.SysRoleMenuEditCommand;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.MultiResponse;

import java.util.List;
import javax.validation.Valid;

/**
 * 角色和菜单关联表(SysRoleMenu)表服务接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:41
 */
public interface SysRoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysRoleMenuCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysRoleMenuCO> queryAll(SysRoleMenuQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysRoleMenuCO> queryPage(SysRoleMenuPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysRoleMenuAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysRoleMenuEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

}
