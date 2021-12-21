package com.wyl.upms.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 岗位信息表(SysPost)实体类
 *
 * @author wyl
 * @since 2021-12-21 09:48:14
 */
@Data
public class SysPost extends BaseEntity {

    /**
     * 岗位ID
     */
    private Long postId;
    /**
     * 岗位编码
     */
    private String postCode;
    /**
     * 岗位名称
     */
    private String postName;
    /**
     * 显示顺序
     */
    private Integer postSort;
    /**
     * 状态（0正常 1停用）
     */
    private String status;

}
