package com.wyl.dict.web;

import cn.wyl.common.core.dto.MultiResponse;
import com.wyl.dict.service.IDictDataService;
import com.wyl.dict.dto.clientobject.DictDataCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据字典信息
 *
 * @author wyl
 * @since 2021-11-26 15:03:28
 */
@RestController
@RequestMapping("/dict/data")
public class DictDataController {

    @Autowired
    private IDictDataService dictDataService;

    /**
     * 根据字典类型查询字典数据信息
     */
    @GetMapping(value = "/type/{dictType}")
    public MultiResponse<DictDataCO> dictType(@PathVariable String dictType) {
        return dictDataService.selectDictDataByType(dictType);
    }

}
