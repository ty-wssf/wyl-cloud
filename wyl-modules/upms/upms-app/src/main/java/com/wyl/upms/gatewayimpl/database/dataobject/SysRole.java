package com.wyl.upms.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 角色信息表(SysRole)实体类
 *
 * @author wyl
 * @since 2021-12-21 13:22:27
 */
@Data
public class SysRole extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限字符串
     */
    private String roleKey;
    /**
     * 显示顺序
     */
    private Integer roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    private Integer dataScope;
    /**
     * 角色状态（0正常 1停用）
     */
    private Integer status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

}
