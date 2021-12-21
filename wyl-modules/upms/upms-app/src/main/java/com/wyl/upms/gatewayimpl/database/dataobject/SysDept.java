package com.wyl.upms.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 部门表(SysDept)实体类
 *
 * @author wyl
 * @since 2021-12-20 16:10:09
 */
@Data
public class SysDept extends BaseEntity {

    /**
     * 部门id
     */
    private Long deptId;
    /**
     * 父部门id
     */
    private Long parentId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 显示顺序
     */
    private Integer orderNum;
    /**
     * 负责人
     */
    private String leader;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 部门状态（0正常 1停用）
     */
    private String status;
    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;

}
