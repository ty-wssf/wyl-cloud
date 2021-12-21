package com.wyl.upms.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import com.wyl.upms.gatewayimpl.database.dataobject.SysPost;
import com.wyl.upms.dto.clientobject.SysPostCO;
import com.wyl.upms.dto.qry.SysPostQry;
import com.wyl.upms.dto.qry.SysPostPageQry;
import com.wyl.upms.dto.command.SysPostAddCommand;
import com.wyl.upms.dto.command.SysPostEditCommand;
import com.wyl.upms.domain.gateway.SysPostGateway;
import com.wyl.upms.service.SysPostService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import cn.hutool.core.bean.BeanUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.validation.Valid;
import java.util.stream.Collectors;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;

/**
 * 岗位信息表(SysPost)表服务实现类
 *
 * @author wyl
 * @since 2021-12-21 09:48:15
 */
@Validated
@Service
@CatchAndLog
public class SysPostServiceImpl implements SysPostService {
    @Resource
    private SysPostGateway sysPostGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysPostCO> queryByPrimaryKey(Long primaryKey) {
        SysPost sysPost = this.sysPostGateway.queryByPrimaryKey(primaryKey);
        SysPostCO sysPostCO = new SysPostCO();
        BeanUtil.copyProperties(sysPost, sysPostCO);
        return SingleResponse.of(sysPostCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysPostCO> queryAll(SysPostQry qry) {
        SysPost sysPostDO = new SysPost();
        BeanUtil.copyProperties(qry, sysPostDO);
        List<SysPost> sysPostList = sysPostGateway.queryAll(sysPostDO);
        List<SysPostCO> sysPostCOList = sysPostList.stream().map(sysPost -> {
            SysPostCO sysPostCO = new SysPostCO();
            BeanUtil.copyProperties(sysPost, sysPostCO);
            return sysPostCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysPostCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysPostCO> queryPage(SysPostPageQry pageQry) {
        SysPost sysPostDO = new SysPost();
        BeanUtil.copyProperties(pageQry, sysPostDO);
        PageResponse<SysPost> pageResponse = sysPostGateway.queryPage(sysPostDO);
        List<SysPost> sysPostList = pageResponse.getData();
        List<SysPostCO> sysPostCOList = sysPostList.stream().map(sysPost -> {
            SysPostCO sysPostCO = new SysPostCO();
            BeanUtil.copyProperties(sysPost, sysPostCO);
            return sysPostCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysPostCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysPostAddCommand command) {
        SysPost sysPost = new SysPost();
        BeanUtil.copyProperties(command, sysPost);
        this.sysPostGateway.insert(sysPost);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysPostEditCommand command) {
        SysPost sysPost = new SysPost();
        BeanUtil.copyProperties(command, sysPost);
        this.sysPostGateway.update(sysPost);
        return Response.buildSuccess();
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    @Override
    public Response deleteByPrimaryKeys(Long[] primaryKeys) {
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysPostGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
