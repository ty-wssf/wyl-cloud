package cn.wyl.common.core.tree;

import cn.hutool.core.bean.BeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author wyl
 * @since 2021-09-06 10:19:47
 */
public class TreeTest {

    public static void main(String[] args) {
        // 最简单使用方式
        List<Tree> list = new ArrayList<>();
        list.add(Tree.create().set("id", 5).set("pid", 4).set("name", "5name"));
        list.add(Tree.create().set("id", 4).set("pid", 3).set("name", "4name"));
        list.add(Tree.create().set("id", 3).set("pid", 2).set("name", "3name"));
        List<Tree> treeList = TreeSupport.list2tree(list, Tree::setChildren);
        System.out.println(treeList);

        List<Tree> list4 = new ArrayList<>();
        list4.add(Tree.create().setId(5).setParentId(4).setName("5name"));
        list4.add(Tree.create().setId(4).setParentId(3).setName("4name"));
        list4.add(Tree.create().setId(3).setParentId(2).setName("3name"));
        List<Tree> treeList4 = TreeSupport.list2tree(list4, Tree::setChildren);
        System.out.println(treeList4);

        // 自定义节点名称
        List<Tree> list1 = new ArrayList<>();
        list1.add(Tree.create().set("id1", 5).set("pid", 4).set("name", "5name").setIdKey("id1"));
        list1.add(Tree.create().set("id1", 4).set("pid", 3).set("name", "4name").setIdKey("id1"));
        list1.add(Tree.create().set("id1", 3).set("pid", 2).set("name", "3name").setIdKey("id1"));
        List<Tree> treeList1 = TreeSupport.list2tree(list1, Tree::setChildren);
        System.out.println(treeList1);

        // 自定义父节点规则1
        List<Tree> list2 = new ArrayList<>();
        list2.add(Tree.create().set("id", 5).set("pid", 4).set("name", "5name"));
        list2.add(Tree.create().set("id", 4).set("pid", 3).set("name", "4name"));
        list2.add(Tree.create().set("id", 3).set("pid", 2).set("name", "3name"));
        List<Tree> treeList2 = TreeSupport.list2tree(list2, Tree::setChildren, (Predicate<Tree>) node -> "4".equals(String.valueOf(node.getId())));
        System.out.println(treeList2);

        // 自定义父节点规则2（如果父节点规则比较复杂使用该方法）
        List<Tree> list3 = new ArrayList<>();
        list3.add(Tree.create().set("id", 5).set("pid", 4).set("name", "5name"));
        list3.add(Tree.create().set("id", 4).set("pid", 3).set("name", "4name"));
        list3.add(Tree.create().set("id", 3).set("pid", 2).set("name", "3name"));
        List<Tree> treeList3 = TreeSupport.list2tree(list2, Tree::setChildren,
                (Function<TreeSupport.TreeHelper<Tree, Object>, Predicate<Tree>>) treeHelper -> node -> node == null || treeHelper.getNode(node.getParentId()) == null);
        System.out.println(treeList3);


        TreeTest treeTest = new TreeTest();
        Tree tree = (Tree) BeanUtil.beanToMap(treeTest);
    }

}
