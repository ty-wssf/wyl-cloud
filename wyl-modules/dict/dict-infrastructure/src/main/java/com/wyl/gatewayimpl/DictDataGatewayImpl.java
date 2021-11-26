package com.wyl.gatewayimpl;

import com.wyl.domain.gateway.DictDataGateway;
import com.wyl.gatewayimpl.database.SysDictDataMapper;
import com.wyl.gatewayimpl.database.dataobject.SysDictData;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典数据
 *
 * @author wyl
 * @since 2021-11-26 14:50:45
 */
@Component
public class DictDataGatewayImpl implements DictDataGateway {

    @Resource
    private SysDictDataMapper dictDataMapper;

    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        return dictDataMapper.selectByDictType(dictType);
    }

}
