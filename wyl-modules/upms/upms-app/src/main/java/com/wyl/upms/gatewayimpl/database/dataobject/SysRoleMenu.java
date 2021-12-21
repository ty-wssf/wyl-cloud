package com.wyl.upms.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 角色和菜单关联表(SysRoleMenu)实体类
 *
 * @author wyl
 * @since 2021-12-21 13:22:40
 */
@Data
public class SysRoleMenu extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;

}
