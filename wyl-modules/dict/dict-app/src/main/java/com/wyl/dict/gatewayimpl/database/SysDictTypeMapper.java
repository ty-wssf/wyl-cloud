package com.wyl.dict.gatewayimpl.database;

import com.wyl.dict.gatewayimpl.database.dataobject.SysDictType;

import java.util.List;

/**
 * @Entity com.wyl.gatewayimpl.database.dataobject.SysDictType
 */
public interface SysDictTypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysDictType record);

    int insertSelective(SysDictType record);

    SysDictType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDictType record);

    int updateByPrimaryKey(SysDictType record);

    List<SysDictType> selectAllByParams(SysDictType record);

}
