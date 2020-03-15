package utils;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 可重复的TreeSet
 *
 * @author: yry
 * @date: 2020/3/15
 */
public class TreeMultiSetOld<E> extends TreeMap<E, Integer> {

    // 总个数(重复算多个)
    private transient int size = 0;

    public TreeMultiSetOld(Comparator<? super E> comparator) {
        super(comparator);
    }

    /**
     * 返回总的元素个数（重复算多个）
     * @return 总的元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 返回不同的元素个数。
     * @return 不同的元素个数
     */
    public int diffElementSize() {
        // 也就是treeMap的key的个数
        return size();
    }

    /**
     * 获取第一个元素（如果比较器是从小到大的，第一个元素就是最小的，否则就是最大的）
     * @return 第一个元素
     */
    public E first() {
        return firstKey();
    }

    /**
     * 获取最后元素（如果比较器是从小到大的，第一个元素就是最大的，否则就是最小的）
     * @return 最后一个元素
     */
    public E last() {
        return lastKey();
    }

    /**
     * 获取到指定元素的个数
     * @param e 指定元素
     * @return 指定元素的个数
     */
    public int count(E e) {
        return get(e);
    }

    /**
     * 是否包含某个元素
     * @param e 指定元素
     * @return true-包含，false-不包含
     */
    public boolean contains(E e) {
        return containsKey(e);
    }

    /**
     * 添加指定元素(1个)
     * @param e 要添加的元素
     */
    public void add(E e) {
        add(e, 1);
    }

    /**
     * 添加指定个数的元素，如果当前元素已经存在，则当前元素的数量+count，否则新建一个key。
     * @param e 要添加的元素
     * @param count 要添加的指定元素的个数
     */
    public void add(E e, int count) {
        if (containsKey(e)) {
            put(e, this.get(e) + count);
        } else {
            put(e, count);
        }
        size += count;
    }

    public void setCount(E e, int count) {
        int oldCount = containsKey(e) ? get(e) : 0;
        put(e, count);
        size = size - oldCount + count;
    }

    /**
     * 移除count个指定元素，比如集合为[2,3,3,3,2], 若调用removeCount(3,2)，也就是移除2两个2，那么集合就变成[2,3,2]
     * @param e 要移除的元素
     * @param count 要移除的指定元素的个数
     * @return 是否移除成功，若移除的元素不存在，返回false, 若移除的元素存在，但是要移除的count大于存在的count，返回false。否则返回true
     */
    public boolean removeCount(E e, int count) {
        if (!containsKey(e)) {
            return false;
        }

        int curCount = get(e);
        if (curCount < count) {
            return false;
        } else if (curCount == count) {
            remove(e);
        } else {
            put(e, curCount - count);
        }

        size -= count;
        return true;
    }

    public boolean removeOneCount(E e) {
        return removeCount(e, 1);
    }

    /**
     * 移除指定元素（包括所有的指定元素）。比如集合为[2,3,3,3,2]，若调用removeKey(3)，那么会移除所有的3，则集合变成[2,2]
     * @param e 要移除的元素
     * @return 是否移除成功，若移除的元素不存在，返回false，否则返回true
     */
    public boolean removeAllCount(E e) {
        if (!containsKey(e)) {
            return false;
        }

        size -= get(e);
        remove(e);
        return true;
    }

    /**
     * 删除第一个元素（指定数量）
     * @param count 指定数量
     * @return 第一个元素
     */
    public E pollFirst(int count) {
        E firstKey = firstKey();
        removeCount(firstKey, count);
        return firstKey;
    }

    /**
     * 移除第一个元素(包括所有数量)
     * @return 第一个元素
     */
    public E pollFirst() {
        // firstKey如果不存在可能会抛异常
        E firstKey = firstKey();
        size -= get(firstKey);
        remove(firstKey);
        return firstKey;
    }

    /**
     * 删除第一个元素（指定数量）
     * @param count 指定数量
     * @return 第一个元素
     */
    public E pollLast(int count) {
        // lastKey如果不存在可能会抛异常
        E lastKey = lastKey();
        size -= get(lastKey);
        removeCount(lastKey, count);
        return lastKey;
    }

    /**
     * 移除最后一个元素(包括所有数量)
     * @return 最后一个元素
     */
    public E pollLast() {
        E lastKey = lastKey();
        size -= get(lastKey);
        remove(lastKey);
        return lastKey;
    }

    /**
     * 不使用TreeMap自带的remove功能，直接用{@link TreeMultiSetOld#removeAllCount(E)}
     */
    @Deprecated
    @Override
    public Integer remove(Object key) {
        return super.remove(key);
    }

}
