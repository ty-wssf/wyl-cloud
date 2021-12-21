package com.wyl.upms.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 角色和菜单关联表(SysRoleMenu)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:55
 */
@ApiModel("角色和菜单关联表分页查询模型")
@Data
public class SysRoleMenuPageQry extends SysRoleMenuQry {

    private PageQuery pageQuery;

}
