package com.wyl.dict.service;

import com.wyl.dict.dto.clientobject.SysDictDataCO;
import com.wyl.dict.dto.qry.SysDictDataQry;
import com.wyl.dict.dto.qry.SysDictDataPageQry;
import com.wyl.dict.dto.command.SysDictDataAddCommand;
import com.wyl.dict.dto.command.SysDictDataEditCommand;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.MultiResponse;

import javax.validation.Valid;

/**
 * 字典数据表(SysDictData)表服务接口
 *
 * @author wyl
 * @since 2021-12-17 21:35:55
 */
public interface SysDictDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysDictDataCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysDictDataCO> queryAll(SysDictDataQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysDictDataCO> queryPage(SysDictDataPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysDictDataAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysDictDataEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return
     */
    MultiResponse<SysDictDataCO> queryDictDataByType(String dictType);

}
