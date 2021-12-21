package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色信息表(SysRole)客户端对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:53
 */
@Data
public class SysRoleCO implements Serializable {
    private static final long serialVersionUID = 679911881447157479L;

    /**
     * 角色ID
     */
    @Excel(name = "角色ID")
    private Long roleId;
    /**
     * 角色名称
     */
    @Excel(name = "角色名称")
    private String roleName;
    /**
     * 角色权限字符串
     */
    @Excel(name = "角色权限字符串")
    private String roleKey;
    /**
     * 显示顺序
     */
    @Excel(name = "显示顺序")
    private Integer roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @Excel(name = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
    private String dataScope;
    /**
     * 菜单树选择项是否关联显示
     */
    @Excel(name = "菜单树选择项是否关联显示")
    private Integer menuCheckStrictly;
    /**
     * 部门树选择项是否关联显示
     */
    @Excel(name = "部门树选择项是否关联显示")
    private Integer deptCheckStrictly;
    /**
     * 角色状态（0正常 1停用）
     */
    @Excel(name = "角色状态（0正常 1停用）")
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @Excel(name = "删除标志（0代表存在 2代表删除）")
    private String delFlag;
    /**
     * 创建者
     */
    @Excel(name = "创建者")
    private String createBy;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    private Date createTime;
    /**
     * 更新者
     */
    @Excel(name = "更新者")
    private String updateBy;
    /**
     * 更新时间
     */
    @Excel(name = "更新时间")
    private Date updateTime;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;

}
