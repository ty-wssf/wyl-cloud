package com.wyl.dict.command;

import com.alibaba.cola.dto.MultiResponse;
import com.wyl.dict.dto.DictTypeListQry;
import com.wyl.dict.dto.clientobject.SysDictTypeCO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wyl
 * @since 2021-11-17 09:37:25
 */
@Component
public class DictTypeListQryExe {

    public MultiResponse<List<SysDictTypeCO>> execute(DictTypeListQry qry) {
        return null;
    }

}
