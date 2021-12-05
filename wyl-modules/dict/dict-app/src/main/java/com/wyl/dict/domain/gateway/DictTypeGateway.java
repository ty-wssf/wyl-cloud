package com.wyl.dict.domain.gateway;

import cn.wyl.common.core.dto.PageResponse;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictType;

/**
 * 字典配型
 *
 * @author wyl
 * @since 2021-11-22 11:34:08
 */
public interface DictTypeGateway {

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
