package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.tree.SortSupport;
import cn.wyl.common.core.tree.TreeSupport;
import lombok.Data;

import java.util.List;

/**
 * @author wyl
 * @since 2021-12-20 17:13:48
 */
@Data
public class SysDeptTreeCO extends SysDeptCO implements TreeSupport<Long>, SortSupport {

    private List<SysDeptTreeCO> children;

    @Override
    public Long getSortIndex() {
        return getOrderNum();
    }

    @Override
    public Long getId() {
        return getDeptId();
    }

}
