package com.wyl.dict.gatewayimpl.database;

import com.wyl.dict.gatewayimpl.database.dataobject.SysDictDataDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity generator.domain.SysDictData
 */
@Mapper
public interface SysDictDataMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysDictDataDO record);

    int insertSelective(SysDictDataDO record);

    SysDictDataDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDictDataDO record);

    int updateByPrimaryKey(SysDictDataDO record);

}
