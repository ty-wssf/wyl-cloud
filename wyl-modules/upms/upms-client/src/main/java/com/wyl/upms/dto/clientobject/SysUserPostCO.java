package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户与岗位关联表(SysUserPost)客户端对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:56
 */
@Data
public class SysUserPostCO implements Serializable {
    private static final long serialVersionUID = 337714001794321462L;

    /**
     * 用户ID
     */
    @Excel(name = "用户ID")
    private Long userId;
    /**
     * 岗位ID
     */
    @Excel(name = "岗位ID")
    private Long postId;

}
