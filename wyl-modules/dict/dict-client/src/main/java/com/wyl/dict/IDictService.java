package com.wyl.dict;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.wyl.dict.dto.*;
import com.wyl.dict.dto.clientobject.SysDictTypeCO;

import java.util.List;

/**
 * 字典服务
 *
 * @author wyl
 * @since 2021-11-17 08:58:23
 */
public interface IDictService {

    /**
     * 新增保存字典类型信息
     *
     * @param cmd 字典类型信息
     */
    Response insertDictType(DictTypeInsertCmd cmd);

    /**
     * 新增保存字典数据信息
     *
     * @param cmd 字典数据信息
     */
    Response insertDictData(DictDataInsertCmd cmd);

    /**
     * 修改保存字典类型信息
     *
     * @param cmd 字典类型信息
     */
    Response updateDictType(DictTypeUpdateCmd cmd);

    /**
     * 修改保存字典数据信息
     *
     * @param cmd 字典数据信息
     */
    Response updateDictData(DictDataUpdateCmd cmd);

    /**
     * 批量删除字典信息
     *
     * @param cmd 需要删除的字典ID
     * @return 结果
     */
    Response deleteDictTypeByIds(DictTypeDeleteCmd cmd);

    /**
     * 批量删除字典数据信息
     *
     * @param cmd 需要删除的字典数据ID
     * @return 结果
     */
    Response deleteDictDataByIds(DictDataDeleteCmd cmd);

    /**
     * 根据条件查询字典类型列表
     *
     * @param qry 字典类型信息
     * @return 字典类型集合信息
     */
    MultiResponse<List<SysDictTypeCO>> selectDictTypeList(DictTypeListQry qry);

    /**
     * 根据字典类型ID查询信息
     *
     * @param qry 字典类型ID
     * @return 字典类型
     */
    SingleResponse<SysDictTypeCO> selectDictTypeById(DictTypeByIdQry qry);

    /**
     * 根据字典类型查询信息
     *
     * @param qry 字典类型
     * @return 字典类型
     */
    SingleResponse<SysDictTypeCO> selectDictTypeByType(DictTypeByTypeQry qry);

    /**
     * 根据字典类型查询字典数据
     *
     * @param qry 字典类型
     * @return 字典数据集合信息
     */
    public List<DictDataCO> selectDictDataByType(DictDataByTypeQry qry);

}
