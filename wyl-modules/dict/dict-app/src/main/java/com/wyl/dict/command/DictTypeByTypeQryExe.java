package com.wyl.dict.command;

import com.alibaba.cola.dto.SingleResponse;
import com.wyl.dict.dto.DictTypeByTypeQry;
import com.wyl.dict.dto.clientobject.SysDictTypeCO;
import org.springframework.stereotype.Component;

/**
 * @author wyl
 * @since 2021-11-17 09:39:45
 */
@Component
public class DictTypeByTypeQryExe {

    public SingleResponse<SysDictTypeCO> execute(DictTypeByTypeQry qry) {
        return null;
    }

}
