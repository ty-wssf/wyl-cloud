package com.wyl.dict.web;

import cn.wyl.common.core.web.controller.BaseController;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.wyl.api.IConfigService;
import com.wyl.dto.ConfigAddCmd;
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

    /**
     * 获取参数配置列表
     */
    @GetMapping("/pageList")
    public PageResponse<ConfigCO> pageList(ConfigPageQry qry) {
        return configService.pageSelectConfigList(qry);
    }

    /**
     * 新增参数配置
     */
    @PostMapping
    public Response add(@Validated @RequestBody ConfigAddCmd configAddCmd) {
        return configService.addConfig(configAddCmd);
    }

}
