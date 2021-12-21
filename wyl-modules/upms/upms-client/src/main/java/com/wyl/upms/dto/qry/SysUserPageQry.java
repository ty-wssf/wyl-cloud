package com.wyl.upms.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 用户信息表(SysUser)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:56
 */
@ApiModel("用户信息表分页查询模型")
@Data
public class SysUserPageQry extends SysUserQry {

    private PageQuery pageQuery;

}
