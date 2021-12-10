package com.wyl.dict.web;

import cn.wyl.common.core.catchlog.CatchAndLog;
import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import cn.wyl.common.core.web.controller.BaseController;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wyl.dict.dto.ConfigQry;
import com.wyl.dict.service.IConfigService;
import com.wyl.dict.dto.ConfigAddCmd;
import com.wyl.dict.dto.ConfigEditCmd;
import com.wyl.dict.dto.ConfigPageQry;
import com.wyl.dict.dto.clientobject.ConfigCO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "配置管理模块")
@CatchAndLog
@RequestMapping("/config")
@RestController
public class ConfigController extends BaseController {

    @Autowired
    private IConfigService configService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页参数配置列表")
    @GetMapping("/pageList")
    public PageResponse<ConfigCO> pageList(ConfigPageQry qry) {
        return configService.selectPageConfigList(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据参数主键查询配置详情")
    @GetMapping(value = "/{configId}")
    public SingleResponse<ConfigCO> getConfig(@ApiParam(value = "参数主键", required = true)
                                              @PathVariable Long configId) {
        return configService.getConfigInfo(configId);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增参数配置")
    @PostMapping
    public Response addConfig(@Validated @RequestBody ConfigAddCmd configAddCmd) {
        return configService.addConfig(configAddCmd);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑参数配置")
    @PutMapping
    public Response editConfig(@Validated @RequestBody ConfigEditCmd configEditCmd) {
        return configService.editConfig(configEditCmd);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除参数配置")
    @DeleteMapping("/{configIds}")
    public Response removeConfig(@ApiParam(value = "参数主键", required = true)
                                 @PathVariable Long[] configIds) {
        return configService.removeConfig(configIds);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出参数配置")
    @RequestMapping("/export")
    public void export(HttpServletResponse response, ConfigQry qry) {
        MultiResponse<ConfigCO> list = configService.selectConfigList(qry);
        ExcelUtil<ConfigCO> util = new ExcelUtil<ConfigCO>(ConfigCO.class);
        util.exportExcel(response, list.getData(), "参数数据");
    }
    /* 基础接口结束 */

    @ApiOperationSupport(order = 11)
    @ApiOperation(value = "根据参数键名查询参数配置")
    @GetMapping(value = "/configKey/{configKey}")
    public SingleResponse<String> get(@ApiParam(value = "参数键名", required = true)
                                      @PathVariable String configKey) {
        return configService.getConfigValueByKey(configKey);
    }

}
