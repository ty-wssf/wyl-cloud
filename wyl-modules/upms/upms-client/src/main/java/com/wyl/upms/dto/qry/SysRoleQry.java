package com.wyl.upms.dto.qry;

import lombok.Data;

import java.util.Date;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色信息表(SysRole)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:53
 */
@ApiModel("角色信息表查询模型")
@Data
public class SysRoleQry extends Query {

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", position = 1)
    private String roleName;
    /**
     * 角色权限字符串
     */
    @ApiModelProperty(value = "角色权限字符串", position = 2)
    private String roleKey;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", position = 3)
    private Integer roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @ApiModelProperty(value = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）", position = 4)
    private String dataScope;
    /**
     * 菜单树选择项是否关联显示
     */
    @ApiModelProperty(value = "菜单树选择项是否关联显示", position = 5)
    private Integer menuCheckStrictly;
    /**
     * 部门树选择项是否关联显示
     */
    @ApiModelProperty(value = "部门树选择项是否关联显示", position = 6)
    private Integer deptCheckStrictly;
    /**
     * 角色状态（0正常 1停用）
     */
    @ApiModelProperty(value = "角色状态（0正常 1停用）", position = 7)
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）", position = 8)
    private String delFlag;

}
