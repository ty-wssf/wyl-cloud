package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 部门表(SysDept)客户端对象
 *
 * @author wyl
 * @since 2021-12-20 16:09:00
 */
@Data
public class SysDeptCO implements Serializable {
    private static final long serialVersionUID = -76636030496351116L;

    /**
     * 部门id
     */
    @Excel(name = "部门id")
    private Long deptId;
    /**
     * 父部门id
     */
    @Excel(name = "父部门id")
    private Long parentId;
    /**
     * 部门名称
     */
    @Excel(name = "部门名称")
    private String deptName;
    /**
     * 显示顺序
     */
    @Excel(name = "显示顺序")
    private Long orderNum;
    /**
     * 负责人
     */
    @Excel(name = "负责人")
    private String leader;
    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    private String phone;
    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;
    /**
     * 部门状态（0正常 1停用）
     */
    @Excel(name = "部门状态（0正常 1停用）")
    private String status;
    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @Excel(name = "删除标志（0代表存在 1代表删除）")
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

}
