package com.wyl.domain.gateway;

import com.alibaba.cola.dto.PageResponse;
import com.wyl.gatewayimpl.database.dataobject.SysDictType;

/**
 * @author wyl
 * @since 2021-11-22 11:34:08
 */
public interface DictGateway {

    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    PageResponse<SysDictType> pageSelectDictTypeList(SysDictType dictType);

    /**
     * 根据字典类型ID查询信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    SysDictType selectDictTypeById(Long dictId);

}
