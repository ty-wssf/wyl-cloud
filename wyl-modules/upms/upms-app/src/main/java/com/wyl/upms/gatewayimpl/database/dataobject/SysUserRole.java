package com.wyl.upms.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 用户和角色关联表(SysUserRole)实体类
 *
 * @author wyl
 * @since 2021-12-21 13:22:53
 */
@Data
public class SysUserRole extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;

}
