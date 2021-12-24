package com.wyl.upms.web;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import cn.wyl.common.core.web.controller.BaseController;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.wyl.upms.dto.clientobject.SysDeptCO;
import com.wyl.upms.dto.clientobject.SysDeptTreeCO;
import com.wyl.upms.dto.command.SysDeptAddCommand;
import com.wyl.upms.dto.command.SysDeptEditCommand;
import com.wyl.upms.dto.qry.SysDeptPageQry;
import com.wyl.upms.dto.qry.SysDeptQry;
import com.wyl.upms.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 部门表(SysDept)表控制层
 *
 * @author wyl
 * @since 2021-12-20 16:11:14
 */
@ApiSort(40)
@Api(tags = "部门表模块")
@RestController
@RequestMapping("sysDept")
public class SysDeptController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysDeptService sysDeptService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public PageResponse<SysDeptCO> pageList(SysDeptPageQry qry) {
        return this.sysDeptService.queryPage(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据主键查询详情")
    @GetMapping(value = "/{id}")
    public SingleResponse<SysDeptCO> getInfo(@ApiParam(value = "主键", required = true)
                                             @PathVariable Long id) {
        return this.sysDeptService.queryByPrimaryKey(id);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增")
    @PostMapping
    public Response add(@Validated @RequestBody SysDeptAddCommand command) {
        return this.sysDeptService.insert(command);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑")
    @PutMapping("{id}")
    public Response edit(@Validated @RequestBody SysDeptEditCommand command, @PathVariable Long id) {
        command.setDeptId(id);
        return this.sysDeptService.update(command);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除")
    @DeleteMapping("/{ids}")
    public Response remove(@ApiParam(value = "主键", required = true)
                           @PathVariable Long[] ids) {
        return this.sysDeptService.deleteByPrimaryKeys(ids);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDeptQry qry) {
        MultiResponse<SysDeptCO> list = sysDeptService.queryAll(qry);
        ExcelUtil<SysDeptCO> util = new ExcelUtil<SysDeptCO>(SysDeptCO.class);
        util.exportExcel(response, list.getData(), "部门表数据");
    }
    /* 基础接口结束 */

    @ApiOperationSupport(order = 11)
    @ApiOperation(value = "树结构部门列表")
    @GetMapping("/tree")
    public MultiResponse<SysDeptTreeCO> treeList(SysDeptQry qry) {
        return this.sysDeptService.treeList(qry);
    }

}
