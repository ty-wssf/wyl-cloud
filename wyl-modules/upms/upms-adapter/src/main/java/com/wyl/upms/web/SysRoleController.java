package com.wyl.upms.web;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import cn.wyl.common.core.web.controller.BaseController;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.wyl.upms.dto.clientobject.SysRoleCO;
import com.wyl.upms.dto.command.SysRoleAddCommand;
import com.wyl.upms.dto.command.SysRoleEditCommand;
import com.wyl.upms.dto.qry.SysRolePageQry;
import com.wyl.upms.dto.qry.SysRoleQry;
import com.wyl.upms.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 角色信息表(SysRole)表控制层
 *
 * @author wyl
 * @since 2021-12-21 13:24:10
 */
@ApiSort(20)
@Api(tags = "角色信息表模块")
@RestController
@RequestMapping("sysRole")
public class SysRoleController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public PageResponse<SysRoleCO> pageList(SysRolePageQry qry) {
        return this.sysRoleService.queryPage(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据主键查询详情")
    @GetMapping(value = "/{id}")
    public SingleResponse<SysRoleCO> getInfo(@ApiParam(value = "主键", required = true)
                                             @PathVariable Long id) {
        return this.sysRoleService.queryByPrimaryKey(id);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增")
    @PostMapping
    public Response add(@Validated @RequestBody SysRoleAddCommand command) {
        return this.sysRoleService.insert(command);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑")
    @PutMapping("{id}")
    public Response edit(@Validated @RequestBody SysRoleEditCommand command, @PathVariable Long id) {
        command.setRoleId(id);
        return this.sysRoleService.update(command);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除")
    @DeleteMapping("/{ids}")
    public Response remove(@ApiParam(value = "主键", required = true)
                           @PathVariable Long[] ids) {
        return this.sysRoleService.deleteByPrimaryKeys(ids);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRoleQry qry) {
        MultiResponse<SysRoleCO> list = sysRoleService.queryAll(qry);
        ExcelUtil<SysRoleCO> util = new ExcelUtil<SysRoleCO>(SysRoleCO.class);
        util.exportExcel(response, list.getData(), "角色信息表数据");
    }
    /* 基础接口结束 */

}
