package cn.wyl.common.core.tree;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.map.MapUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyl
 * @since 2021-06-28 09:48:27
 */
public class Tree<PK> extends LinkedHashMap<String, Object> implements TreeSupport<PK>, SortSupport {

    private TreeNodeConfig treeNodeConfig = TreeNodeConfig.DEFAULT_CONFIG;

    public static Tree create() {
        return new Tree();
    }

    public static Tree create(TreeNodeConfig treeNodeConfig) {
        return new Tree(treeNodeConfig);
    }

    private Tree() {
        this(null);
    }

    public Tree(TreeNodeConfig treeNodeConfig) {
        this.treeNodeConfig = (null != treeNodeConfig) ? treeNodeConfig : TreeNodeConfig.create();
    }

    public Tree<PK> set(String attr, Object value) {
        this.put(attr, value);
        return this;
    }

    public Tree<PK> setAll(Map<String, Object> m) {
        this.putAll(m);
        return this;
    }

    @Override
    public PK getId() {
        return MapUtil.get(this, treeNodeConfig.getIdKey(), new TypeReference<PK>() {
        });
    }

    public Tree<PK> setId(PK id) {
        this.put(treeNodeConfig.getIdKey(), id);
        return this;
    }

    @Override
    public PK getParentId() {
        return MapUtil.get(this, treeNodeConfig.getParentIdKey(), new TypeReference<PK>() {
        });
    }

    public Tree<PK> setParentId(PK parentId) {
        this.put(treeNodeConfig.getParentIdKey(), parentId);
        return this;
    }

    public String getName() {
        return MapUtil.get(this, treeNodeConfig.getNameKey(), String.class);
    }

    public Tree<PK> setName(String name) {
        this.put(treeNodeConfig.getNameKey(), name);
        return this;
    }

    @Override
    public List<Tree<PK>> getChildren() {
        return MapUtil.get(this, treeNodeConfig.getChildrenKey(), new TypeReference<List<Tree<PK>>>() {
        });
    }

    public Tree<PK> setChildren(List<Tree<PK>> children) {
        this.put(treeNodeConfig.getChildrenKey(), children);
        return this;
    }

    @Override
    public Long getSortIndex() {
        return MapUtil.get(this, treeNodeConfig.getSortKey(), new TypeReference<Long>() {
        });
    }

    public Tree<PK> setSortIndex(Long sortIndex) {
        this.put(treeNodeConfig.getSortKey(), sortIndex);
        return this;
    }

    public Tree<PK> setIdKey(String idKey) {
        treeNodeConfig.setIdKey(idKey);
        return this;
    }

    public Tree<PK> setParentIdKey(String parentIdKey) {
        treeNodeConfig.setParentIdKey(parentIdKey);
        return this;
    }

    public Tree<PK> setNameKey(String nameKey) {
        treeNodeConfig.setNameKey(nameKey);
        return this;
    }

    public Tree<PK> setChildrenKey(String childrenKey) {
        treeNodeConfig.setChildrenKey(childrenKey);
        return this;
    }

    public Tree<PK> setSortKey(String sortKey) {
        treeNodeConfig.setSortKey(sortKey);
        return this;
    }

}
