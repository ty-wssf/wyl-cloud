package com.wyl.upms.service;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.upms.dto.clientobject.SysRoleDeptCO;
import com.wyl.upms.dto.command.SysRoleDeptAddCommand;
import com.wyl.upms.dto.command.SysRoleDeptEditCommand;
import com.wyl.upms.dto.qry.SysRoleDeptPageQry;
import com.wyl.upms.dto.qry.SysRoleDeptQry;

import javax.validation.Valid;

/**
 * 角色和部门关联表(SysRoleDept)表服务接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:40
 */
public interface SysRoleDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysRoleDeptCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysRoleDeptCO> queryAll(SysRoleDeptQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysRoleDeptCO> queryPage(SysRoleDeptPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysRoleDeptAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysRoleDeptEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

}
