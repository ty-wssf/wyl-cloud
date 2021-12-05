package com.wyl.dict.domain.gateway;

import com.wyl.dict.gatewayimpl.database.dataobject.SysDictData;

import java.util.List;

/**
 * 字典数据
 *
 * @author wyl
 * @since 2021-11-26 14:45:12
 */
public interface DictDataGateway {

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    List<SysDictData> selectDictDataByType(String dictType);

}
