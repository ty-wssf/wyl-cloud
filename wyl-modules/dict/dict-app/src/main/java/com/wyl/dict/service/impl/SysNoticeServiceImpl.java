package com.wyl.dict.service.impl;

import com.wyl.dict.gatewayimpl.database.dataobject.SysNotice;
import com.wyl.dict.dto.clientobject.SysNoticeCO;
import com.wyl.dict.dto.qry.SysNoticeQry;
import com.wyl.dict.dto.qry.SysNoticePageQry;
import com.wyl.dict.dto.command.SysNoticeAddCommand;
import com.wyl.dict.dto.command.SysNoticeEditCommand;
import com.wyl.dict.domain.gateway.SysNoticeGateway;
import com.wyl.dict.service.SysNoticeService;
import org.springframework.stereotype.Service;
import cn.hutool.core.bean.BeanUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;

/**
 * 通知公告表(SysNotice)表服务实现类
 *
 * @author wyl
 * @since 2021-12-15 09:07:25
 */
@Service
public class SysNoticeServiceImpl implements SysNoticeService {
    @Resource
    private SysNoticeGateway sysNoticeGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysNoticeCO> queryByPrimaryKey(Integer primaryKey) {
        SysNotice sysNotice = this.sysNoticeGateway.queryByPrimaryKey(primaryKey);
        SysNoticeCO sysNoticeCO = new SysNoticeCO();
        BeanUtil.copyProperties(sysNotice, sysNoticeCO);
        return SingleResponse.of(sysNoticeCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysNoticeCO> queryAll(SysNoticeQry qry) {
        SysNotice sysNoticeDO = new SysNotice();
        BeanUtil.copyProperties(qry, sysNoticeDO);
        List<SysNotice> sysNoticeList = this.sysNoticeGateway.queryAll(sysNoticeDO);
        List<SysNoticeCO> sysNoticeCOList = sysNoticeList.stream().map(sysNotice -> {
            SysNoticeCO sysNoticeCO = new SysNoticeCO();
            BeanUtil.copyProperties(sysNotice, sysNoticeCO);
            return sysNoticeCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysNoticeCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysNoticeCO> queryPage(SysNoticePageQry pageQry) {
        SysNotice sysNoticeDO = new SysNotice();
        BeanUtil.copyProperties(pageQry, sysNoticeDO);
        PageResponse<SysNotice> pageResponse = sysNoticeGateway.queryPage(sysNoticeDO);
        List<SysNotice> sysNoticeList = pageResponse.getData();
        List<SysNoticeCO> sysNoticeCOList = sysNoticeList.stream().map(sysNotice -> {
            SysNoticeCO sysNoticeCO = new SysNoticeCO();
            BeanUtil.copyProperties(sysNotice, sysNoticeCO);
            return sysNoticeCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysNoticeCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(SysNoticeAddCommand command) {
        SysNotice sysNotice = new SysNotice();
        BeanUtil.copyProperties(command, sysNotice);
        this.sysNoticeGateway.insert(sysNotice);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysNoticeEditCommand command) {
        SysNotice sysNotice = new SysNotice();
        BeanUtil.copyProperties(command, sysNotice);
        this.sysNoticeGateway.update(sysNotice);
        return Response.buildSuccess();
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    @Override
    public Response deleteByPrimaryKeys(Integer[] primaryKeys) {
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysNoticeGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}