package com.wyl.upms.service;

import com.wyl.upms.gatewayimpl.database.dataobject.SysPost;
import com.wyl.upms.dto.clientobject.SysPostCO;
import com.wyl.upms.dto.qry.SysPostQry;
import com.wyl.upms.dto.qry.SysPostPageQry;
import com.wyl.upms.dto.command.SysPostAddCommand;
import com.wyl.upms.dto.command.SysPostEditCommand;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.MultiResponse;

import java.util.List;
import javax.validation.Valid;

/**
 * 岗位信息表(SysPost)表服务接口
 *
 * @author wyl
 * @since 2021-12-21 09:48:15
 */
public interface SysPostService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysPostCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysPostCO> queryAll(SysPostQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysPostCO> queryPage(SysPostPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysPostAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysPostEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

}
