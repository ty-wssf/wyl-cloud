package com.wyl.gatewayimpl.database;

import com.wyl.gatewayimpl.database.dataobject.SysDictData;

/**
 * @Entity com.wyl.gatewayimpl.database.dataobject.SysDictData
 */
public interface SysDictDataMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysDictData record);

    int insertSelective(SysDictData record);

    SysDictData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDictData record);

    int updateByPrimaryKey(SysDictData record);

}
