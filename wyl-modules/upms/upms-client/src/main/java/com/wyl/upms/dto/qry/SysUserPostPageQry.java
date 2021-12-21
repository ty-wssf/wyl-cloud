package com.wyl.upms.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 用户与岗位关联表(SysUserPost)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:57
 */
@ApiModel("用户与岗位关联表分页查询模型")
@Data
public class SysUserPostPageQry extends SysUserPostQry {

    private PageQuery pageQuery;

}
