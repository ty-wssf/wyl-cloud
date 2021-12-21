package com.wyl.upms.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 角色和部门关联表(SysRoleDept)实体类
 *
 * @author wyl
 * @since 2021-12-21 13:22:39
 */
@Data
public class SysRoleDept extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 部门ID
     */
    private Long deptId;

}
