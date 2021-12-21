package com.wyl.upms.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 用户和角色关联表(SysUserRole)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:57
 */
@ApiModel("用户和角色关联表分页查询模型")
@Data
public class SysUserRolePageQry extends SysUserRoleQry {

    private PageQuery pageQuery;

}
