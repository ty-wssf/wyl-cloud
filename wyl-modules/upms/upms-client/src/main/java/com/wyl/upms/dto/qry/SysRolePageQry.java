package com.wyl.upms.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 角色信息表(SysRole)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:53
 */
@ApiModel("角色信息表分页查询模型")
@Data
public class SysRolePageQry extends SysRoleQry {

    private PageQuery pageQuery;

}
