package cn.wyl.common.core.tree;

/**
 * ζεΊζ―ζ
 *
 * @author wyl
 * @since 2021-07-15 17:10:14
 */
public interface SortSupport extends Comparable<SortSupport> {

    Long getSortIndex();

    @Override
    default int compareTo(SortSupport support) {
        if (support == null) {
            return -1;
        }
        return Long.compare(getSortIndex() == null ? 0 : getSortIndex(), support.getSortIndex() == null ? 0 : support.getSortIndex());
    }

}
