package com.wyl.dict.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.wyl.dict.IDictService;
import com.wyl.dict.command.*;
import com.wyl.dict.dto.*;
import com.wyl.dict.dto.clientobject.SysDictTypeCO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wyl
 * @since 2021-11-17 09:15:00
 */
@Service
@CatchAndLog
public class DictServiceImpl implements IDictService {

    @Resource
    private DictTypeInsertCmdExe dictTypeInsertCmdExe;
    @Resource
    private DictDataInsertCmdExe dictDataInsertCmdExe;
    @Resource
    private DictTypeUpdateCmdExe dictTypeUpdateCmdExe;
    @Resource
    private DictDataUpdateCmdExe dictDataUpdateCmdExe;
    @Resource
    private DictTypeDeleteCmdExe dictTypeDeleteCmdExe;
    @Resource
    private DictDataDeleteCmdExe dictDataDeleteCmdExe;
    @Resource
    private DictTypeListQryExe dictTypeListQryExe;
    @Resource
    private DictTypeByIdQryExe dictTypeByIdQryExe;
    @Resource
    private DictTypeByTypeQryExe dictTypeByTypeQryExe;
    @Resource
    private DictDataByTypeQryExe dictDataByTypeQryExe;

    @Override
    public Response insertDictType(DictTypeInsertCmd cmd) {
        return dictTypeInsertCmdExe.execute(cmd);
    }

    @Override
    public Response insertDictData(DictDataInsertCmd cmd) {
        return dictDataInsertCmdExe.execute(cmd);
    }

    @Override
    public Response updateDictType(DictTypeUpdateCmd cmd) {
        return dictTypeUpdateCmdExe.execute(cmd);
    }

    @Override
    public Response updateDictData(DictDataUpdateCmd cmd) {
        return dictDataUpdateCmdExe.execute(cmd);
    }

    @Override
    public Response deleteDictTypeByIds(DictTypeDeleteCmd cmd) {
        return dictTypeDeleteCmdExe.execute(cmd);
    }

    @Override
    public Response deleteDictDataByIds(DictDataDeleteCmd cmd) {
        return dictDataDeleteCmdExe.execute(cmd);
    }

    @Override
    public MultiResponse<List<SysDictTypeCO>> selectDictTypeList(DictTypeListQry qry) {
        return dictTypeListQryExe.execute(qry);
    }

    @Override
    public SingleResponse<SysDictTypeCO> selectDictTypeById(DictTypeByIdQry qry) {
        return dictTypeByIdQryExe.execute(qry);
    }

    @Override
    public SingleResponse<SysDictTypeCO> selectDictTypeByType(DictTypeByTypeQry qry) {
        return dictTypeByTypeQryExe.execute(qry);
    }

    @Override
    public List<DictDataCO> selectDictDataByType(DictDataByTypeQry qry) {
        return dictDataByTypeQryExe.execute(qry);
    }

}
