package com.wyl.upms.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import com.wyl.upms.gatewayimpl.database.dataobject.SysUserPost;
import com.wyl.upms.dto.clientobject.SysUserPostCO;
import com.wyl.upms.dto.qry.SysUserPostQry;
import com.wyl.upms.dto.qry.SysUserPostPageQry;
import com.wyl.upms.dto.command.SysUserPostAddCommand;
import com.wyl.upms.dto.command.SysUserPostEditCommand;
import com.wyl.upms.domain.gateway.SysUserPostGateway;
import com.wyl.upms.service.SysUserPostService;
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
 * 用户与岗位关联表(SysUserPost)表服务实现类
 *
 * @author wyl
 * @since 2021-12-21 13:22:53
 */
@Validated
@Service
@CatchAndLog
public class SysUserPostServiceImpl implements SysUserPostService {
    @Resource
    private SysUserPostGateway sysUserPostGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysUserPostCO> queryByPrimaryKey(Long primaryKey) {
        SysUserPost sysUserPost = this.sysUserPostGateway.queryByPrimaryKey(primaryKey);
        SysUserPostCO sysUserPostCO = new SysUserPostCO();
        BeanUtil.copyProperties(sysUserPost, sysUserPostCO);
        return SingleResponse.of(sysUserPostCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysUserPostCO> queryAll(SysUserPostQry qry) {
        SysUserPost sysUserPostDO = new SysUserPost();
        BeanUtil.copyProperties(qry, sysUserPostDO);
        List<SysUserPost> sysUserPostList = sysUserPostGateway.queryAll(sysUserPostDO);
        List<SysUserPostCO> sysUserPostCOList = sysUserPostList.stream().map(sysUserPost -> {
            SysUserPostCO sysUserPostCO = new SysUserPostCO();
            BeanUtil.copyProperties(sysUserPost, sysUserPostCO);
            return sysUserPostCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysUserPostCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysUserPostCO> queryPage(SysUserPostPageQry pageQry) {
        SysUserPost sysUserPostDO = new SysUserPost();
        BeanUtil.copyProperties(pageQry, sysUserPostDO);
        PageResponse<SysUserPost> pageResponse = sysUserPostGateway.queryPage(sysUserPostDO);
        List<SysUserPost> sysUserPostList = pageResponse.getData();
        List<SysUserPostCO> sysUserPostCOList = sysUserPostList.stream().map(sysUserPost -> {
            SysUserPostCO sysUserPostCO = new SysUserPostCO();
            BeanUtil.copyProperties(sysUserPost, sysUserPostCO);
            return sysUserPostCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysUserPostCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysUserPostAddCommand command) {
        SysUserPost sysUserPost = new SysUserPost();
        BeanUtil.copyProperties(command, sysUserPost);
        this.sysUserPostGateway.insert(sysUserPost);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysUserPostEditCommand command) {
        SysUserPost sysUserPost = new SysUserPost();
        BeanUtil.copyProperties(command, sysUserPost);
        this.sysUserPostGateway.update(sysUserPost);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysUserPostGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
