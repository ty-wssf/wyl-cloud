package com.wyl.dict.web;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.fastjson.JSON;
import com.wyl.api.IConfigService;
import com.wyl.dto.ConfigPageQry;
import com.wyl.dto.clientobject.ConfigCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.Map;

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

    /**
     * 将前台传递过来的字符串，自动转化为Map类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Map 类型转换
        binder.registerCustomEditor(Map.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(JSON.parseObject(text, Map.class));
            }
        });
    }

}
