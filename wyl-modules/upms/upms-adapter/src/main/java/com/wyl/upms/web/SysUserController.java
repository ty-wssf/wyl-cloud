package com.wyl.upms.web;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import cn.wyl.common.core.web.controller.BaseController;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.wyl.upms.dto.clientobject.SysUserCO;
import com.wyl.upms.dto.command.SysUserAddCommand;
import com.wyl.upms.dto.command.SysUserEditCommand;
import com.wyl.upms.dto.qry.SysUserPageQry;
import com.wyl.upms.dto.qry.SysUserQry;
import com.wyl.upms.gatewayimpl.database.dataobject.SysUser;
import com.wyl.upms.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息表(SysUser)表控制层
 *
 * @author wyl
 * @since 2021-12-21 13:24:10
 */
@ApiSort(10)
@Api(tags = "用户信息表模块")
@RestController
@RequestMapping("sysUser")
public class SysUserController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public PageResponse<SysUserCO> pageList(SysUserPageQry qry) {
        return this.sysUserService.queryPage(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据主键查询详情")
    @GetMapping(value = "/{id}")
    public SingleResponse<SysUserCO> getInfo(@ApiParam(value = "主键", required = true)
                                             @PathVariable Long id) {
        return this.sysUserService.queryByPrimaryKey(id);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增")
    @PostMapping
    public Response add(@Validated @RequestBody SysUserAddCommand command) {
        return this.sysUserService.insert(command);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑")
    @PutMapping("{id}")
    public Response edit(@RequestBody SysUserEditCommand command, @PathVariable Long id) {
        command.setUserId(id);
        return this.sysUserService.update(command);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除")
    @DeleteMapping("/{ids}")
    public Response remove(@ApiParam(value = "主键", required = true)
                           @PathVariable Long[] ids) {
        return this.sysUserService.deleteByPrimaryKeys(ids);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUserQry qry) {
        MultiResponse<SysUserCO> list = sysUserService.queryAll(qry);
        ExcelUtil<SysUserCO> util = new ExcelUtil<SysUserCO>(SysUserCO.class);
        util.exportExcel(response, list.getData(), "用户信息表数据");
    }
    /* 基础接口结束 */

    @ApiOperation(value = "重置密码")
    @PutMapping("/resetPwd/{userId}")
    public Response resetPwd(@RequestBody SysUser user, @PathVariable Long userId) {
        user.setUserId(userId);
        return sysUserService.resetPwd(user);
    }

}
