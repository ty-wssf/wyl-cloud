package com.wyl.dict.web;

import cn.wyl.common.core.web.controller.BaseController;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.wyl.api.IConfigService;
import com.wyl.dto.ConfigAddCmd;
import com.wyl.dto.ConfigEditCmd;
import com.wyl.dto.ConfigPageQry;
import com.wyl.dto.clientobject.ConfigCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/config")
@RestController
public class ConfigController extends BaseController {

    @Autowired
    private IConfigService configService;

    /* 基础接口开始 */
    @GetMapping("/pageList")
    public PageResponse<ConfigCO> pageList(ConfigPageQry qry) {
        return configService.pageSelectConfigList(qry);
    }

    @GetMapping(value = "/{configId}")
    public SingleResponse<ConfigCO> getInfo(@PathVariable Long configId) {
        return configService.getConfigInfo(configId);
    }

    @PostMapping
    public Response addConfig(@Validated @RequestBody ConfigAddCmd configAddCmd) {
        return null;//configService.addConfig(configAddCmd);
    }

    @PutMapping
    public Response editConfig(@Validated @RequestBody ConfigEditCmd configEditCmd) {
        return configService.editConfig(configEditCmd);
    }

    @DeleteMapping("/{configIds}")
    public Response removeConfig(@PathVariable Long[] configIds) {
        return configService.removeConfig(configIds);
    }
    /* 基础接口结束 */

    @GetMapping(value = "/configKey/{configKey}")
    public SingleResponse<String> get(@PathVariable String configKey) {
        return configService.getConfigValueByKey(configKey);
    }

}
