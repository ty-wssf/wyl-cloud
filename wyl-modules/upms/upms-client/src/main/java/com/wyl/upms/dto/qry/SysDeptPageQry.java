package com.wyl.upms.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 部门表(SysDept)查询对象
 *
 * @author wyl
 * @since 2021-12-20 16:09:08
 */
@ApiModel("部门表分页查询模型")
@Data
public class SysDeptPageQry extends SysDeptQry {

    private PageQuery pageQuery;

}
