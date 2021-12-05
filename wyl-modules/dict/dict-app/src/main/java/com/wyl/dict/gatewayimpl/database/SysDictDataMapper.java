package com.wyl.dict.gatewayimpl.database;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<SysDictData> selectByDictType(@Param("dictType") String dictType);

}
