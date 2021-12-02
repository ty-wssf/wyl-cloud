package com.wyl.gatewayimpl.database;
import com.wyl.gatewayimpl.database.dataobject.SysConfig;

import java.util.List;

/**
 * @Entity com.wyl.gatewayimpl.database.dataobject.SysConfig
 */
public interface SysConfigMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

    List<SysConfig> selectAllBySelective(SysConfig record);

    SysConfig selectOneBySelective(SysConfig record);

}
