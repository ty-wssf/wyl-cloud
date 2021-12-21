package com.wyl.dict.web;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import cn.wyl.common.core.web.controller.BaseController;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.wyl.dict.dto.clientobject.SysDictTypeCO;
import com.wyl.dict.dto.command.SysDictTypeAddCommand;
import com.wyl.dict.dto.command.SysDictTypeEditCommand;
import com.wyl.dict.dto.qry.SysDictTypePageQry;
import com.wyl.dict.dto.qry.SysDictTypeQry;
import com.wyl.dict.service.SysDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 字典类型表(SysDictType)表控制层
 *
 * @author wyl
 * @since 2021-12-17 21:26:43
 */
@ApiSort(10)
@Api(tags = "字典类型表模块")
@RestController
@RequestMapping("dict/type")
public class SysDictTypeController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysDictTypeService sysDictTypeService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public PageResponse<SysDictTypeCO> pageList(SysDictTypePageQry qry) {
        return this.sysDictTypeService.queryPage(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据主键查询详情")
    @GetMapping(value = "/{id}")
    public SingleResponse<SysDictTypeCO> getInfo(@ApiParam(value = "主键", required = true)
                                                 @PathVariable Long id) {
        return this.sysDictTypeService.queryByPrimaryKey(id);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增")
    @PostMapping
    public Response add(@Validated @RequestBody SysDictTypeAddCommand command) {
        return this.sysDictTypeService.insert(command);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑")
    @PutMapping("{id}")
    public Response edit(@Validated @RequestBody SysDictTypeEditCommand command, @PathVariable Long id) {
        command.setDictId(id);
        return this.sysDictTypeService.update(command);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除")
    @DeleteMapping("/{ids}")
    public Response remove(@ApiParam(value = "主键", required = true)
                           @PathVariable Long[] ids) {
        return this.sysDictTypeService.deleteByPrimaryKeys(ids);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDictTypeQry qry) {
        MultiResponse<SysDictTypeCO> list = sysDictTypeService.queryAll(qry);
        ExcelUtil<SysDictTypeCO> util = new ExcelUtil<SysDictTypeCO>(SysDictTypeCO.class);
        util.exportExcel(response, list.getData(), "字典类型表数据");
    }
    /* 基础接口结束 */

}
