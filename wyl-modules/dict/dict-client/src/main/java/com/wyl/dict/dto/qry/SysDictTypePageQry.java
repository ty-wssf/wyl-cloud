package com.wyl.dict.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 字典类型表(SysDictType)查询对象
 *
 * @author wyl
 * @since 2021-12-17 21:10:58
 */
@ApiModel("字典类型表分页查询模型")
@Data
public class SysDictTypePageQry extends SysDictTypeQry {

    private PageQuery pageQuery;

}
