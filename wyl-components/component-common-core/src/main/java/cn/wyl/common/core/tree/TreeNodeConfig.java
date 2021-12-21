package cn.wyl.common.core.tree;

import cn.hutool.core.util.ObjectUtil;

import java.io.Serializable;

/**
 * @author wyl
 * @since 2021-07-15 12:31:34
 */
public class TreeNodeConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 默认属性配置对象
     */
    public static TreeNodeConfig DEFAULT_CONFIG = new TreeNodeConfig();

    // 属性名配置字段
    private String idKey = "id";
    private String parentIdKey = "pid";
    private String nameKey = "name";
    private String childrenKey = "children";
    private String sortKey = "sortIndex";

    public static TreeNodeConfig create() {
        return ObjectUtil.clone(DEFAULT_CONFIG);
    }

    public String getIdKey() {
        return idKey;
    }

    public TreeNodeConfig setIdKey(String idKey) {
        this.idKey = idKey;
        return this;
    }

    public String getParentIdKey() {
        return parentIdKey;
    }

    public TreeNodeConfig setParentIdKey(String parentIdKey) {
        this.parentIdKey = parentIdKey;
        return this;
    }

    public String getNameKey() {
        return nameKey;
    }

    public TreeNodeConfig setNameKey(String nameKey) {
        this.nameKey = nameKey;
        return this;
    }

    public String getChildrenKey() {
        return childrenKey;
    }

    public TreeNodeConfig setChildrenKey(String childrenKey) {
        this.childrenKey = childrenKey;
        return this;
    }

    public String getSortKey() {
        return sortKey;
    }

    public TreeNodeConfig setSortKey(String sortKey) {
        this.sortKey = sortKey;
        return this;
    }

}
