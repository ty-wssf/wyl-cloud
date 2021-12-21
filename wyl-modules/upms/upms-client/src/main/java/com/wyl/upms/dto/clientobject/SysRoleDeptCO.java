package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色和部门关联表(SysRoleDept)客户端对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:54
 */
@Data
public class SysRoleDeptCO implements Serializable {
    private static final long serialVersionUID = 986781209403665868L;

    /**
     * 角色ID
     */
    @Excel(name = "角色ID")
    private Long roleId;
    /**
     * 部门ID
     */
    @Excel(name = "部门ID")
    private Long deptId;

}
