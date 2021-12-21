package com.wyl.upms.service;

import com.wyl.upms.gatewayimpl.database.dataobject.SysMenu;
import com.wyl.upms.dto.clientobject.SysMenuCO;
import com.wyl.upms.dto.qry.SysMenuQry;
import com.wyl.upms.dto.qry.SysMenuPageQry;
import com.wyl.upms.dto.command.SysMenuAddCommand;
import com.wyl.upms.dto.command.SysMenuEditCommand;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.MultiResponse;

import java.util.List;
import javax.validation.Valid;

/**
 * 菜单权限表(SysMenu)表服务接口
 *
 * @author wyl
 * @since 2021-12-21 13:21:38
 */
public interface SysMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysMenuCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysMenuCO> queryAll(SysMenuQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysMenuCO> queryPage(SysMenuPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysMenuAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysMenuEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

}
