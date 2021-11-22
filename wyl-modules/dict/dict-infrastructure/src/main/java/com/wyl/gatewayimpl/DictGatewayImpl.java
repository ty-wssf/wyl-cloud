package com.wyl.gatewayimpl;

import com.alibaba.cola.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyl.domain.gateway.DictGateway;
import com.wyl.gatewayimpl.database.SysDictTypeMapper;
import com.wyl.gatewayimpl.database.dataobject.SysDictType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wyl
 * @since 2021-11-22 11:35:34
 */
@Component
@Slf4j
public class DictGatewayImpl implements DictGateway {

    @Resource
    private SysDictTypeMapper dictTypeMapper;

    @Override
    public PageResponse<SysDictType> pageSelectDictTypeList(SysDictType dictType) {
        PageHelper.startPage(dictType.getPageIndex(), dictType.getPageSize());
        List<SysDictType> dictTypeList = dictTypeMapper.selectAllByParams(dictType);
        PageInfo<SysDictType> pageInfo = new PageInfo<SysDictType>(dictTypeList);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    @Override
    public SysDictType selectDictTypeById(Long dictId) {
        return dictTypeMapper.selectByPrimaryKey(dictId);
    }

}
