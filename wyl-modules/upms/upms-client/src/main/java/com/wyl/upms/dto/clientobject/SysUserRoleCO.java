package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户和角色关联表(SysUserRole)客户端对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:57
 */
@Data
public class SysUserRoleCO implements Serializable {
    private static final long serialVersionUID = 773426270536119504L;

    /**
     * 用户ID
     */
    @Excel(name = "用户ID")
    private Long userId;
    /**
     * 角色ID
     */
    @Excel(name = "角色ID")
    private Long roleId;

}
