package com.wyl.dict.web;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import cn.wyl.common.core.web.controller.BaseController;
import com.wyl.dict.service.SysDictDataService;
import com.wyl.dict.dto.clientobject.SysDictDataCO;
import com.wyl.dict.dto.qry.SysDictDataPageQry;
import com.wyl.dict.dto.qry.SysDictDataQry;
import com.wyl.dict.dto.command.SysDictDataAddCommand;
import com.wyl.dict.dto.command.SysDictDataEditCommand;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * 字典数据表(SysDictData)表控制层
 *
 * @author wyl
 * @since 2021-12-17 21:36:11
 */
@Api(tags = "字典数据表模块")
@RestController
@RequestMapping("sysDictData")
public class SysDictDataController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysDictDataService sysDictDataService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public PageResponse<SysDictDataCO> pageList(SysDictDataPageQry qry) {
        return this.sysDictDataService.queryPage(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据主键查询详情")
    @GetMapping(value = "/{id}")
    public SingleResponse<SysDictDataCO> getInfo(@ApiParam(value = "主键", required = true)
                                                 @PathVariable Long id) {
        return this.sysDictDataService.queryByPrimaryKey(id);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增")
    @PostMapping
    public Response add(@Validated @RequestBody SysDictDataAddCommand command) {
        return this.sysDictDataService.insert(command);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑")
    @PutMapping("{id}")
    public Response edit(@Validated @RequestBody SysDictDataEditCommand command, @PathVariable Long id) {
        command.setDictCode(id);
        return this.sysDictDataService.update(command);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除")
    @DeleteMapping("/{ids}")
    public Response remove(@ApiParam(value = "主键", required = true)
                           @PathVariable Long[] ids) {
        return this.sysDictDataService.deleteByPrimaryKeys(ids);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDictDataQry qry) {
        MultiResponse<SysDictDataCO> list = sysDictDataService.queryAll(qry);
        ExcelUtil<SysDictDataCO> util = new ExcelUtil<SysDictDataCO>(SysDictDataCO.class);
        util.exportExcel(response, list.getData(), "字典数据表数据");
    }
    /* 基础接口结束 */

    /**
     * 根据字典类型查询字典数据信息
     */
    @GetMapping(value = "/type/{dictType}")
    public MultiResponse<SysDictDataCO> dictType(@PathVariable String dictType) {
        return sysDictDataService.queryDictDataByType(dictType);
    }

}
