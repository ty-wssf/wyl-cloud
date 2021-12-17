package com.wyl.dict.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 字典数据表(SysDictData)查询对象
 *
 * @author wyl
 * @since 2021-12-17 21:35:33
 */
@ApiModel("字典数据表分页查询模型")
@Data
public class SysDictDataPageQry extends SysDictDataQry {

    private PageQuery pageQuery;

}
