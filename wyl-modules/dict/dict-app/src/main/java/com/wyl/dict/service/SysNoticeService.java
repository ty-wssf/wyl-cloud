package com.wyl.dict.service;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.dict.dto.clientobject.SysNoticeCO;
import com.wyl.dict.dto.command.SysNoticeAddCommand;
import com.wyl.dict.dto.command.SysNoticeEditCommand;
import com.wyl.dict.dto.qry.SysNoticePageQry;
import com.wyl.dict.dto.qry.SysNoticeQry;

import javax.validation.Valid;

/**
 * 通知公告表(SysNotice)表服务接口
 *
 * @author wyl
 * @since 2021-12-17 09:08:55
 */
public interface SysNoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysNoticeCO> queryByPrimaryKey(Integer primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysNoticeCO> queryAll(SysNoticeQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysNoticeCO> queryPage(SysNoticePageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysNoticeAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysNoticeEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Integer[] primaryKeys);

}
