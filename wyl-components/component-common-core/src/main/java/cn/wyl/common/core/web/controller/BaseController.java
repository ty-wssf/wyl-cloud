package cn.wyl.common.core.web.controller;

import cn.wyl.common.core.dto.PageQuery;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Map;

/**
 * web层通用数据处理
 *
 * @author wyl
 * @since 2021-11-30 16:36:28
 */
public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Map 类型转换
        binder.registerCustomEditor(Map.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(JSON.parseObject(text, Map.class));
            }
        });

        // PageQuery
        binder.registerCustomEditor(PageQuery.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(JSON.parseObject(text, PageQuery.class));
            }
        });
    }

}
