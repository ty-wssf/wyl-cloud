package com.wyl.upms.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 岗位信息表(SysPost)查询对象
 *
 * @author wyl
 * @since 2021-12-21 09:47:52
 */
@ApiModel("岗位信息表分页查询模型")
@Data
public class SysPostPageQry extends SysPostQry {

    private PageQuery pageQuery;

}
