package com.wyl.dict.web;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import cn.wyl.common.core.web.controller.BaseController;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wyl.dict.dto.clientobject.SysConfigCO;
import com.wyl.dict.dto.command.SysConfigAddCommand;
import com.wyl.dict.dto.command.SysConfigEditCommand;
import com.wyl.dict.dto.qry.SysConfigPageQry;
import com.wyl.dict.dto.qry.SysConfigQry;
import com.wyl.dict.service.SysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 参数配置表(SysConfig)表控制层
 *
 * @author wyl
 * @since 2021-12-17 16:15:26
 */
@Api(tags = "参数配置表模块")
@RestController
@RequestMapping("sysConfig")
public class SysConfigController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysConfigService sysConfigService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public PageResponse<SysConfigCO> pageList(SysConfigPageQry qry) {
        return this.sysConfigService.queryPage(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据主键查询详情")
    @GetMapping(value = "/{id}")
    public SingleResponse<SysConfigCO> getInfo(@ApiParam(value = "主键", required = true)
                                               @PathVariable Long id) {
        return this.sysConfigService.queryByPrimaryKey(id);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增")
    @PostMapping
    public Response add(@Validated @RequestBody SysConfigAddCommand command) {
        return this.sysConfigService.insert(command);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑")
    @PutMapping("{id}")
    public Response edit(@Validated @RequestBody SysConfigEditCommand command, @PathVariable Long id) {
        command.setConfigId(id);
        return this.sysConfigService.update(command);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除")
    @DeleteMapping("/{ids}")
    public Response remove(@ApiParam(value = "主键", required = true)
                           @PathVariable Long[] ids) {
        return this.sysConfigService.deleteByPrimaryKeys(ids);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysConfigQry qry) {
        MultiResponse<SysConfigCO> list = sysConfigService.queryAll(qry);
        ExcelUtil<SysConfigCO> util = new ExcelUtil<SysConfigCO>(SysConfigCO.class);
        util.exportExcel(response, list.getData(), "参数配置表数据");
    }
    /* 基础接口结束 */

    @ApiOperationSupport(order = 11)
    @ApiOperation(value = "根据参数键名查询参数配置")
    @GetMapping(value = "/configKey/{configKey}")
    public SingleResponse<String> get(@ApiParam(value = "参数键名", required = true)
                                      @PathVariable String configKey) {
        return sysConfigService.getConfigValueByKey(configKey);
    }

}
