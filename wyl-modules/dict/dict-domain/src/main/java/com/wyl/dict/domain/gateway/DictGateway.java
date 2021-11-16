package com.wyl.dict.domain.gateway;

import com.wyl.dict.domain.model.SysDictData;
import com.wyl.dict.domain.model.SysDictType;

import java.util.List;

/**
 * 字典网关接口
 *
 * @author wyl
 * @since 2021-11-16 15:58:33
 */
public interface DictGateway {

    /**
     * 新增保存字典类型信息
     *
     * @param dictType 字典类型信息
     */
    void insertDictType(SysDictType dictType);

    /**
     * 新增保存字典数据信息
     *
     * @param dictData 字典数据信息
     */
    void insertDictData(SysDictData dictData);

    /**
     * 修改保存字典类型信息
     *
     * @param dictType 字典类型信息
     */
    void updateDictType(SysDictType dictType);

    /**
     * 修改保存字典数据信息
     *
     * @param dictData 字典数据信息
     */
    void updateDictData(SysDictData dictData);

    /**
     * 批量删除字典信息
     *
     * @param dictIds 需要删除的字典ID
     * @return 结果
     */
    void deleteDictTypeByIds(Long[] dictIds);

    /**
     * 批量删除字典数据信息
     *
     * @param dictCodes 需要删除的字典数据ID
     * @return 结果
     */
    void deleteDictDataByIds(Long[] dictCodes);

    /**
     * 根据条件查询字典类型列表
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * 根据字典类型ID查询信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    SysDictType selectDictTypeById(Long dictId);

    /**
     * 根据字典类型查询信息
     *
     * @param dictType 字典类型
     * @return 字典类型
     */
    public SysDictType selectDictTypeByType(String dictType);

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    public List<SysDictData> selectDictDataByType(String dictType);

}
