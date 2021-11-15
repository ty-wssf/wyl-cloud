package com.wyl.dict.gatewayimpl.database;

import com.wyl.dict.gatewayimpl.database.dataobject.SysDictTypeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity generator.domain.SysDictType
 */
@Mapper
public interface SysDictTypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysDictTypeDO record);

    int insertSelective(SysDictTypeDO record);

    SysDictTypeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDictTypeDO record);

    int updateByPrimaryKey(SysDictTypeDO record);

}
