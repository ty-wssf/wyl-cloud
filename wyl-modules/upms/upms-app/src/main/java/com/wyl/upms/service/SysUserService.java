package com.wyl.upms.service;

import com.wyl.upms.gatewayimpl.database.dataobject.SysUser;
import com.wyl.upms.dto.clientobject.SysUserCO;
import com.wyl.upms.dto.qry.SysUserQry;
import com.wyl.upms.dto.qry.SysUserPageQry;
import com.wyl.upms.dto.command.SysUserAddCommand;
import com.wyl.upms.dto.command.SysUserEditCommand;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.MultiResponse;

import java.util.List;
import javax.validation.Valid;

/**
 * 用户信息表(SysUser)表服务接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:49
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysUserCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysUserCO> queryAll(SysUserQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysUserCO> queryPage(SysUserPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysUserAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysUserEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

}
