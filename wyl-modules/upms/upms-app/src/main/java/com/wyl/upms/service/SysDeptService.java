package com.wyl.upms.service;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.upms.dto.clientobject.SysDeptCO;
import com.wyl.upms.dto.clientobject.SysDeptTreeCO;
import com.wyl.upms.dto.command.SysDeptAddCommand;
import com.wyl.upms.dto.command.SysDeptEditCommand;
import com.wyl.upms.dto.qry.SysDeptPageQry;
import com.wyl.upms.dto.qry.SysDeptQry;

import javax.validation.Valid;

/**
 * 部门表(SysDept)表服务接口
 *
 * @author wyl
 * @since 2021-12-20 16:10:12
 */
public interface SysDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysDeptCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysDeptCO> queryAll(SysDeptQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysDeptCO> queryPage(SysDeptPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysDeptAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysDeptEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

    /**
     * 树结构部门列表
     *
     * @param qry
     * @return
     */
    MultiResponse<SysDeptTreeCO> treeList(SysDeptQry qry);

}
