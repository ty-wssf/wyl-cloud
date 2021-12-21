package com.wyl.upms.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 菜单权限表(SysMenu)查询对象
 *
 * @author wyl
 * @since 2021-12-21 13:22:09
 */
@ApiModel("菜单权限表分页查询模型")
@Data
public class SysMenuPageQry extends SysMenuQry {

    private PageQuery pageQuery;

}
