package com.wyl.dict.service;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.dict.dto.clientobject.SysConfigCO;
import com.wyl.dict.dto.command.SysConfigAddCommand;
import com.wyl.dict.dto.command.SysConfigEditCommand;
import com.wyl.dict.dto.qry.SysConfigPageQry;
import com.wyl.dict.dto.qry.SysConfigQry;

import javax.validation.Valid;

/**
 * 参数配置表(SysConfig)表服务接口
 *
 * @author wyl
 * @since 2021-12-17 16:13:25
 */
public interface SysConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysConfigCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysConfigCO> queryAll(SysConfigQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysConfigCO> queryPage(SysConfigPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysConfigAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysConfigEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

    /**
     * 根据参数键名查询参数配置
     *
     * @param configKey
     * @return
     */
    SingleResponse<String> getConfigValueByKey(String configKey);

}
