package com.wyl.upms.web;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import cn.wyl.common.core.web.controller.BaseController;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.wyl.upms.dto.clientobject.SysPostCO;
import com.wyl.upms.dto.command.SysPostAddCommand;
import com.wyl.upms.dto.command.SysPostEditCommand;
import com.wyl.upms.dto.qry.SysPostPageQry;
import com.wyl.upms.dto.qry.SysPostQry;
import com.wyl.upms.service.SysPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 岗位信息表(SysPost)表控制层
 *
 * @author wyl
 * @since 2021-12-21 09:48:34
 */
@ApiSort(50)
@Api(tags = "岗位信息表模块")
@RestController
@RequestMapping("sysPost")
public class SysPostController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysPostService sysPostService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public PageResponse<SysPostCO> pageList(SysPostPageQry qry) {
        return this.sysPostService.queryPage(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据主键查询详情")
    @GetMapping(value = "/{id}")
    public SingleResponse<SysPostCO> getInfo(@ApiParam(value = "主键", required = true)
                                             @PathVariable Long id) {
        return this.sysPostService.queryByPrimaryKey(id);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增")
    @PostMapping
    public Response add(@Validated @RequestBody SysPostAddCommand command) {
        return this.sysPostService.insert(command);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑")
    @PutMapping("{id}")
    public Response edit(@RequestBody SysPostEditCommand command, @PathVariable Long id) {
        command.setPostId(id);
        return this.sysPostService.update(command);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除")
    @DeleteMapping("/{ids}")
    public Response remove(@ApiParam(value = "主键", required = true)
                           @PathVariable Long[] ids) {
        return this.sysPostService.deleteByPrimaryKeys(ids);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPostQry qry) {
        MultiResponse<SysPostCO> list = sysPostService.queryAll(qry);
        ExcelUtil<SysPostCO> util = new ExcelUtil<SysPostCO>(SysPostCO.class);
        util.exportExcel(response, list.getData(), "岗位信息表数据");
    }
    /* 基础接口结束 */

    @ApiOperationSupport(order = 11)
    @ApiOperation(value = "所有岗位列表")
    @GetMapping("/queryAll")
    public MultiResponse<SysPostCO> queryAll(SysPostQry qry) {
        return this.sysPostService.queryAll(qry);
    }

}
