package com.wyl.dict.service;

import com.wyl.dict.gatewayimpl.database.dataobject.SysDictType;
import com.wyl.dict.dto.clientobject.SysDictTypeCO;
import com.wyl.dict.dto.qry.SysDictTypeQry;
import com.wyl.dict.dto.qry.SysDictTypePageQry;
import com.wyl.dict.dto.command.SysDictTypeAddCommand;
import com.wyl.dict.dto.command.SysDictTypeEditCommand;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.MultiResponse;

import java.util.List;
import javax.validation.Valid;

/**
 * 字典类型表(SysDictType)表服务接口
 *
 * @author wyl
 * @since 2021-12-17 21:12:17
 */
public interface SysDictTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysDictTypeCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysDictTypeCO> queryAll(SysDictTypeQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysDictTypeCO> queryPage(SysDictTypePageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysDictTypeAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysDictTypeEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

}
