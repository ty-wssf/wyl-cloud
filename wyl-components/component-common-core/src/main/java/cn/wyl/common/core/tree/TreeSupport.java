package cn.wyl.common.core.tree;

import cn.hutool.core.collection.CollUtil;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wyl
 * @since 2021-06-28 09:44:21
 */
public interface TreeSupport<PK> extends Serializable {

    PK getId();

    PK getParentId();

    <T extends TreeSupport<PK>> List<T> getChildren();

    static <T extends TreeSupport> void forEach(Collection<T> list, Consumer<T> consumer) {
        Queue<T> queue = new LinkedList<>(list);
        Set<Long> all = new HashSet<>();
        for (T node = queue.poll(); node != null; node = queue.poll()) {
            long hash = System.identityHashCode(node);
            if (all.contains(hash)) {
                continue;
            }
            all.add(hash);
            consumer.accept(node);
            if (!CollectionUtils.isEmpty(node.getChildren())) {
                queue.addAll(node.getChildren());
            }
        }
    }


    /**
     * 集合转为树形结构,返回根节点集合
     *
     * @param dataList      需要转换的集合
     * @param childConsumer 设置子节点回调
     * @param <N>           树节点类型
     * @param <PK>          主键类型
     * @return 树形结构集合
     */
    static <N extends TreeSupport<PK>, PK> List<N> list2tree(Collection<N> dataList, BiConsumer<N, List<N>> childConsumer) {
        return list2tree(dataList, childConsumer, (Function<TreeHelper<N, PK>, Predicate<N>>) treeHelper -> node ->
                node == null || treeHelper.getNode(node.getParentId()) == null
        );
    }

    static <N extends TreeSupport<PK>, PK> List<N> list2tree(Collection<N> dataList,
                                                             BiConsumer<N, List<N>> childConsumer,
                                                             Predicate<N> rootNodePredicate) {
        return list2tree(dataList, childConsumer, (Function<TreeHelper<N, PK>, Predicate<N>>) treeHelper -> rootNodePredicate);
    }

    /**
     * 列表结构转为树结构,并返回根节点集合
     *
     * @param dataList          数据集合
     * @param childConsumer     子节点消费接口,用于设置子节点
     * @param predicateFunction 根节点判断函数,传入helper,获取一个判断是否为跟节点的函数
     * @param <N>               元素类型
     * @param <PK>              主键类型
     * @return 根节点集合
     */
    static <N extends TreeSupport<PK>, PK> List<N> list2tree(final Collection<N> dataList,
                                                             final BiConsumer<N, List<N>> childConsumer,
                                                             final Function<TreeHelper<N, PK>, Predicate<N>> predicateFunction) {
        Objects.requireNonNull(dataList, "source list can not be null");
        Objects.requireNonNull(childConsumer, "child consumer can not be null");
        Objects.requireNonNull(predicateFunction, "root predicate function can not be null");

        if (CollUtil.isNotEmpty(dataList)) {
            if (dataList.stream().findFirst().get() instanceof Comparable) {
                Collections.sort((List) dataList);
            }
        }

        Supplier<Stream<N>> streamSupplier = () -> dataList.stream();
        // id,node
        Map<PK, N> cache = new HashMap<>();
        // parentId,children
        Map<PK, List<N>> treeCache = streamSupplier.get()
                .peek(node -> cache.put(node.getId(), node))
                .filter(e -> e.getParentId() != null)
                .collect(Collectors.groupingBy(TreeSupport::getParentId));

        Predicate<N> rootNodePredicate = predicateFunction.apply(new TreeHelper<N, PK>() {
            @Override
            public List<N> getChildren(PK parentId) {
                return treeCache.get(parentId);
            }

            @Override
            public N getNode(PK id) {
                return cache.get(id);
            }
        });

        return streamSupplier.get()
                //设置每个节点的子节点
                .peek(node -> childConsumer.accept(node, treeCache.get(node.getId()) == null ? Collections.emptyList() : treeCache.get(node.getId())))
                //获取根节点
                .filter(rootNodePredicate)
                .collect(Collectors.toList());
    }

    // 基于树结构进行搜索
    static <N extends TreeSupport<PK>, PK> void search(final Collection<N> rootList, Predicate<N> searchPredicate) {

        TreeHelper treeHelper = new TreeHelper<N, PK>() {
            private final Map<PK, N> cache = new HashMap<>();
            private final Map<PK, String> path = new HashMap<>();

            @Override
            public List<N> getChildren(PK parentId) {
                return cache.get(parentId).getChildren();
            }

            @Override
            public N getNode(PK id) {
                return cache.get(id);
            }

            @Override
            public void addNode(N node) {
                N parentNode = null != node.getParentId() ? this.getNode(node.getParentId()) : null;
                if (parentNode != null) {
                    path.put(node.getId(), this.getPath(this.getNode(node.getParentId())) + "-" + String.valueOf(node.getId()));
                } else {
                    path.put(node.getId(), String.valueOf(node.getId()));
                }
                cache.put(node.getId(), node);
            }

            @Override
            public boolean containsNode(N node) {
                return cache.containsKey(node.getId());
            }

            @Override
            public String getPath(N node) {
                return path.get(node.getId());
            }

        };

        final Set<String> searchList = new HashSet<>();
        Consumer<N> setPathConsumer = node -> {
            treeHelper.addNode(node);
            if (searchPredicate.test(node)) {
                searchList.addAll(Arrays.asList(treeHelper.getPath(node).split("-")));
            }
        };
        forEach(rootList, setPathConsumer);

        filter(rootList, searchList);
    }

    // 基于树结构进行过滤
    static <N extends TreeSupport<PK>, PK> void filter(final Collection<N> rootList, final Collection<String> searchList) {
        Iterator<N> it = rootList.iterator();
        while (it.hasNext()) {
            N node = it.next();
            if (!searchList.contains(node.getId())) {
                it.remove();
            } else {
                if (!CollectionUtils.isEmpty(node.getChildren())) {
                    filter(node.getChildren(), searchList);
                }
            }
        }
    }

    /**
     * 树结构Helper
     *
     * @param <T>  节点类型
     * @param <PK> 主键类型
     */
    interface TreeHelper<T, PK> {
        /**
         * 根据主键获取子节点
         *
         * @param parentId 节点ID
         * @return 子节点集合
         */
        List<T> getChildren(PK parentId);

        /**
         * 根据id获取节点
         *
         * @param id 节点ID
         * @return 节点
         */
        T getNode(PK id);

        default void addNode(T node) {
        }

        default boolean containsNode(T node) {
            return false;
        }

        default String getPath(T node) {
            return null;
        }

    }

}
