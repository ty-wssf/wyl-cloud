package com.wyl.dict.command;

import com.alibaba.cola.dto.SingleResponse;
import com.wyl.dict.dto.DictTypeByIdQry;
import com.wyl.dict.dto.clientobject.SysDictTypeCO;
import org.springframework.stereotype.Component;

/**
 * @author wyl
 * @since 2021-11-17 09:38:25
 */
@Component
public class DictTypeByIdQryExe {

    public SingleResponse<SysDictTypeCO> execute(DictTypeByIdQry qry) {
        return null;
    }

}
