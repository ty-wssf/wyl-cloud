package com.wyl.dict.web;

import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.dict.service.IDictTypeService;
import com.wyl.dict.dto.clientobject.DictTypeCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyl
 * @since 2021-11-22 15:01:48
 */
@RequestMapping("/dict")
@RestController
public class DictTypeController {

    @Autowired
    private IDictTypeService dictService;

    @GetMapping(value = "/type/{dictId}")
    public SingleResponse<DictTypeCO> getInfo(@PathVariable Long dictId) {
        return dictService.selectDictTypeById(dictId);
    }

}
