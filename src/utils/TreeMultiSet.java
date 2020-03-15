package utils;

import java.util.*;

/**
 * 允许重复元素的TreeSet
 *
 * @author: yry
 * @date: 2020/3/15
 */
public class TreeMultiSet<E> extends AbstractSet<E>
        implements NavigableSet<E>, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private transient NavigableMap<E, Integer> treeMap;

    // 总个数(重复算多个)
    private transient int size = 0;

    private TreeMultiSet(NavigableMap<E, Integer> m) {
        this.treeMap = m;
    }

    public TreeMultiSet() {
        this(new TreeMap<>());
    }

    public TreeMultiSet(Comparator<? super E> comparator) {
        this(new TreeMap<>(comparator));
    }

    public TreeMultiSet(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    public TreeMultiSet(SortedSet<E> s) {
        this(s.comparator());
        addAll(s);
    }

    private class Itr implements Iterator<E> {
        private int cursor;
        // 当前treeMap的key对应的
        private Iterator<E> curKeyItr;
        // 当前元素
        private E curVal;
        // 当前treeMap的key对应的索引，即对应当前第几个重复元素
        private int curKeyItrIndex;

        Itr(NavigableSet<E> keySet) {
            cursor = 0;
            curKeyItr = keySet.iterator();
            if (curKeyItr.hasNext()) {
                curVal = curKeyItr.next();
            }
            curKeyItrIndex = 0;
        }

        Itr() {
            this(treeMap.navigableKeySet());
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int curValCount = treeMap.get(curVal);
            E res = null;
            if (curKeyItrIndex < curValCount) {
                curKeyItrIndex++;
                res = curVal;
                if (curKeyItrIndex == curValCount) {
                    // 移动到下一个key
                    if (curKeyItr.hasNext()) {
                        curVal = curKeyItr.next();
                    }
                    curKeyItrIndex = 0;
                }
            }

            cursor++;
            return res;
        }
    }

    /**
     * 返回所有不相同的元素的正向迭代器
     * @return 所有不相同的元素的正向迭代器
     */
    public Iterator<E> diffIterator() {
        return treeMap.navigableKeySet().iterator();
    }

    /**
     * 返回所有不相同的元素的正向迭代器
     * @return 所有不相同的元素的正向迭代器
     */
    public Iterator<E> diffDescendingIterator() {
        return treeMap.descendingKeySet().iterator();
    }

    /**
     * 返回所有元素（重复元素要next多次）的正向迭代器
     * @return 所有元素的正向正向迭代器
     */
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * 返回所有元素（重复元素要next多次）的反向迭代器
     * @return 所有元素的反向迭代器
     */
    @Override
    public Iterator<E> descendingIterator() {
        return new Itr(treeMap.descendingKeySet());
    }

    @Override
    public NavigableSet<E> descendingSet() {
        return new TreeMultiSet<>(treeMap.descendingMap());
    }

    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return new TreeMultiSet<>(treeMap.subMap(fromElement, fromInclusive, toElement,toInclusive));
    }

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return new TreeMultiSet<>(treeMap.headMap(toElement, inclusive));
    }

    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return new TreeMultiSet<>(treeMap.tailMap(fromElement, inclusive));
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        return headSet(toElement, false);
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return tailSet(fromElement, true);
    }

    @Override
    public Comparator<? super E> comparator() {
        return treeMap.comparator();
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
        return treeMap.keySet().size();
    }

    /**
     * 获取第一个元素（如果比较器是从小到大的，第一个元素就是最小的，否则就是最大的）
     * @return 第一个元素
     */
    public E first() {
        return treeMap.firstKey();
    }

    /**
     * 获取最后元素（如果比较器是从小到大的，第一个元素就是最大的，否则就是最小的）
     * @return 最后一个元素
     */
    public E last() {
        return treeMap.lastKey();
    }

    /**
     * 是否包含某个元素
     * @param o 指定元素
     * @return true-包含，false-不包含
     */
    @Override
    public boolean contains(Object o) {
        return treeMap.containsKey(o);
    }

    @Override
    public void clear() {
        treeMap.clear();
    }

    /**
     * 添加指定元素(1个)
     * @param e 要添加的元素
     * @return true
     */
    @Override
    public boolean add(E e) {
        return add(e, 1);
    }

    /**
     * 添加指定个数的元素，如果当前元素已经存在，则当前元素的数量+count，否则新建一个key。
     * @param e 要添加的元素
     * @param count 要添加的指定元素的个数
     */
    public boolean add(E e, int count) {
        if (treeMap.containsKey(e)) {
            treeMap.put(e, treeMap.get(e) + count);
        } else {
            treeMap.put(e, count);
        }
        size += count;
        return true;
    }

    /**
     * 设置指定元素的数量
     * @param e 指定元素
     * @param count 数量
     */
    public void setCount(E e, int count) {
        int oldCount = treeMap.getOrDefault(e, 0);
        treeMap.put(e, count);
        size = size - oldCount + count;
    }

    /**
     * 获取到指定元素的个数
     * @param e 指定元素
     * @return 指定元素的个数
     */
    public int count(E e) {
        return treeMap.get(e);
    }

    /**
     * 移除count个指定元素，比如集合为[2,3,3,3,2], 若调用removeCount(3,2)，也就是移除2两个2，那么集合就变成[2,3,2]
     * @param e 要移除的元素
     * @param count 要移除的指定元素的个数
     * @return 是否移除成功，若移除的元素不存在，返回false, 若移除的元素存在，但是要移除的count大于存在的count，返回false。否则返回true
     */
    public boolean remove(E e, int count) {
        if (!treeMap.containsKey(e)) {
            return false;
        }

        int curCount = treeMap.get(e);
        if (curCount < count) {
            return false;
        } else if (curCount == count) {
            treeMap.remove(e);
        } else {
            treeMap.put(e, curCount - count);
        }

        size -= count;
        return true;
    }

    /**
     * 注意：一定要复写这个方法，目的是覆盖父类Collection的remove操作(复杂度是O(n))
     * 移除1个指定元素
     * @param e 要移除的元素
     * @return 是否移除成功，若移除的元素不存在，返回false, 若移除的元素存在，但是要移除的count大于存在的count，返回false。否则返回true
     */
    public boolean remove(Object e) {
        return remove((E) e, 1);
    }

    /**
     * 移除指定元素（包括所有的指定元素）。比如集合为[2,3,3,3,2]，若调用removeKey(3)，那么会移除所有的3，则集合变成[2,2]
     * @param e 要移除的元素
     * @return 是否移除成功，若移除的元素不存在，返回false，否则返回true
     */
    public boolean removeAll(Object e) {
        if (!treeMap.containsKey(e)) {
            return false;
        }

        size -= treeMap.get(e);
        treeMap.remove(e);
        return true;
    }

    @Override
    public E lower(E e) {
        return treeMap.lowerKey(e);
    }

    @Override
    public E floor(E e) {
        return treeMap.floorKey(e);
    }

    @Override
    public E ceiling(E e) {
        return treeMap.ceilingKey(e);
    }

    @Override
    public E higher(E e) {
        return treeMap.higherKey(e);
    }

    /**
     * 删除第一个元素（指定数量）
     * @param count 指定数量
     * @return 第一个元素
     */
    public E pollFirst(int count) {
        E firstKey = treeMap.firstKey();
        remove(firstKey, count);
        return firstKey;
    }

    /**
     * 移除第一个元素(包括所有数量)
     * @return 第一个元素
     */
    public E pollFirst() {
        // firstKey如果不存在可能会抛异常
        E firstKey = treeMap.firstKey();
        size -= treeMap.get(firstKey);
        treeMap.remove(firstKey);
        return firstKey;
    }

    /**
     * 删除第一个元素（指定数量）
     * @param count 指定数量
     * @return 第一个元素
     */
    public E pollLast(int count) {
        // lastKey如果不存在可能会抛异常
        E lastKey = treeMap.lastKey();
        size -= treeMap.get(lastKey);
        remove(lastKey, count);
        return lastKey;
    }

    /**
     * 移除最后一个元素(包括所有数量)
     * @return 最后一个元素
     */
    public E pollLast() {
        E lastKey = treeMap.lastKey();
        size -= treeMap.get(lastKey);
        treeMap.remove(lastKey);
        return lastKey;
    }

    /**
     * 浅拷贝
     * @return 浅拷贝后的TreeMultiSet
     */
    @SuppressWarnings("unchecked")
    public Object clone() {
        TreeMultiSet<E> clone;
        try {
            clone = (TreeMultiSet<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }

        clone.treeMap = new TreeMap<>(treeMap);
        return clone;
    }

}
