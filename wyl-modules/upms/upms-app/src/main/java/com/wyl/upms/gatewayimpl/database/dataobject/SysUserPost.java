package com.wyl.upms.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 用户与岗位关联表(SysUserPost)实体类
 *
 * @author wyl
 * @since 2021-12-21 13:22:51
 */
@Data
public class SysUserPost extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 岗位ID
     */
    private Long postId;

}
