package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.tree.SortSupport;
import cn.wyl.common.core.tree.TreeSupport;
import lombok.Data;

import java.util.List;

/**
 * @author wyl
 * @since 2021-12-21 13:49:19
 */
@Data
public class SysMenuTreeCO extends SysMenuCO implements TreeSupport<Long>, SortSupport {

    private List<SysMenuTreeCO> children;

    @Override
    public Long getSortIndex() {
        return Long.valueOf(getOrderNum());
    }

    @Override
    public Long getId() {
        return getMenuId();
    }

    @Override
    public List<SysMenuTreeCO> getChildren() {
        return children;
    }

}
