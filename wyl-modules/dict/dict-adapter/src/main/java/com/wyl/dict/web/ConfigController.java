package com.wyl.dict.web;

import com.alibaba.cola.dto.PageResponse;
import com.wyl.api.IConfigService;
import com.wyl.dto.ConfigPageQry;
import com.wyl.dto.clientobject.ConfigCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/config")
@RestController
public class ConfigController {

    @Autowired
    private IConfigService configService;

    /**
     * 获取参数配置列表
     */
    @GetMapping("/pageList")
    public PageResponse<ConfigCO> pageList(ConfigPageQry qry) {
        return configService.pageSelectConfigList(qry);
    }

}
