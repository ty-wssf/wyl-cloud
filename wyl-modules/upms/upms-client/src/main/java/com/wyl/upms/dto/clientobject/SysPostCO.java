package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 岗位信息表(SysPost)客户端对象
 *
 * @author wyl
 * @since 2021-12-21 09:47:52
 */
@Data
public class SysPostCO implements Serializable {
    private static final long serialVersionUID = 138712468908880155L;

    /**
     * 岗位ID
     */
    @Excel(name = "岗位ID")
    private Long postId;
    /**
     * 岗位编码
     */
    @Excel(name = "岗位编码")
    private String postCode;
    /**
     * 岗位名称
     */
    @Excel(name = "岗位名称")
    private String postName;
    /**
     * 显示顺序
     */
    @Excel(name = "显示顺序")
    private Integer postSort;
    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态（0正常 1停用）")
    private String status;
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
