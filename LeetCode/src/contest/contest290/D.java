package contest.contest290;


import java.util.*;

public class D {

    static class TreeMultiSet<E> extends AbstractSet<E>
            implements NavigableSet<E>, Cloneable, java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private transient NavigableMap<E, Integer> treeMap;

        // 总个数(重复算多个)
        private transient int size = 0;

        private TreeMultiSet(NavigableMap<E, Integer> m) {
            this.treeMap = m;
        }

        public TreeMultiSet() {
            this(new TreeMap<E, Integer>());
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

        /**
         * 可重复元素的迭代器
         */
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
         * 返回所有不相同的元素的反向迭代器
         * @return 所有不相同的元素的反向迭代器
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
            return new TreeMultiSet.Itr();
        }

        /**
         * 返回所有元素（重复元素要next多次）的反向迭代器
         * @return 所有元素的反向迭代器
         */
        @Override
        public Iterator<E> descendingIterator() {
            return new TreeMultiSet.Itr(treeMap.descendingKeySet());
        }

        /**
         * 返回逆序集合
         * @return 逆序集合
         */
        @Override
        public NavigableSet<E> descendingSet() {
            TreeMultiSet<E> descendingSet = new TreeMultiSet<>(treeMap.descendingMap());
            descendingSet.size = size;
            return descendingSet;
        }

        /**
         * 计算map中的所有元素个数之和（并不是key的个数，而是sum(key * value)）
         * @param countMap key为元素，value为count的map
         * @return map的所有元素个数之和
         */
        private int calcMapSize(NavigableMap<E, Integer> countMap) {
            int size = 0;
            for (E e : countMap.keySet()) {
                size += countMap.get(e);
            }
            return size;
        }

        /**
         * 返回指定头尾元素的连续子集
         */
        @Override
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            NavigableMap<E, Integer> subMap = treeMap.subMap(fromElement, fromInclusive, toElement, toInclusive);
            TreeMultiSet<E> subSet = new TreeMultiSet<>(subMap);
            subSet.size = calcMapSize(subMap);
            return subSet;
        }

        /**
         * 返回头部连续子集
         */
        @Override
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            NavigableMap<E, Integer> headMap = treeMap.headMap(toElement, inclusive);
            TreeMultiSet<E> headSet = new TreeMultiSet<>(headMap);
            headSet.size = calcMapSize(headMap);
            return headSet;
        }

        /**
         * 返回尾部连续子集
         */
        @Override
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            NavigableMap<E, Integer> tailMap = treeMap.tailMap(fromElement, inclusive);
            TreeMultiSet<E> tailSet = new TreeMultiSet<>(tailMap);
            tailSet.size = calcMapSize(tailMap);
            return tailSet;
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
            if (treeMap.isEmpty()) {
                return null;
            }

            return treeMap.firstKey();
        }

        /**
         * 获取最后一个元素（如果比较器是从小到大的，第一个元素就是最大的，否则就是最小的）
         * @return 最后一个元素
         */
        public E last() {
            if (treeMap.isEmpty()) {
                return null;
            }
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
            size = 0;
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
         * 获取指定元素的个数
         * @param e 指定元素
         * @return 指定元素的个数
         */
        public int count(E e) {
            return treeMap.getOrDefault(e, 0);
        }

        /**
         * 注意：一定要复写这个方法，目的是覆盖父类Collection的remove操作(复杂度是O(n))
         * 删除1个指定元素
         * @param e 要删除的元素
         * @return 是否删除成功，若删除的元素不存在，返回false, 若删除的元素存在，但是要删除的count大于存在的count，返回false。否则返回true
         */
        public boolean remove(Object e) {
            return remove((E) e, 1);
        }

        /**
         * 删除count个指定元素，比如集合为[2,3,3,3,2], 若调用removeCount(3,2)，也就是删除2两个2，那么集合就变成[2,3,2]
         * @param e 要删除的元素
         * @param count 要删除的指定元素的个数
         * @return 是否删除成功，若删除的元素不存在，返回false, 若删除的元素存在，但是要删除的count大于存在的count，返回false。否则返回true
         */
        public boolean remove(E e, int count) {
            if (count <= 0) {
                return false;
            }

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
         * 删除指定元素（包括所有的指定元素）。比如集合为[2,3,3,3,2]，若调用removeKey(3)，那么会删除所有的3，则集合变成[2,2]
         * @param e 要删除的元素
         * @return 是否删除成功，若删除的元素不存在，返回false，否则返回true
         */
        public boolean removeAll(Object e) {
            if (!treeMap.containsKey(e)) {
                return false;
            }

            size -= treeMap.get(e);
            treeMap.remove(e);
            return true;
        }

        /**
         * 返回比给定元素严格小的最大元素
         * @param e 给定元素
         * @return 比给定元素严格小的最大元素，若不存在，则返回null
         */
        @Override
        public E lower(E e) {
            return treeMap.lowerKey(e);
        }

        /**
         * 返回小于或等于给定元素的最大元素
         * @param e 给定元素
         * @return 小于或等于给定元素的最大元素，若不存在，则返回null
         */
        @Override
        public E floor(E e) {
            return treeMap.floorKey(e);
        }

        /**
         * 返回比给定元素严格大的最小元素
         * @param e 给定元素
         * @return 比给定元素严格小的最大元素，若不存在，则返回null
         */
        @Override
        public E higher(E e) {
            return treeMap.higherKey(e);
        }

        /**
         * 返回大于或等于给定元素的最小元素
         * @param e 给定元素
         * @return 大于或等于给定元素的最小元素，若不存在，则返回null
         */
        @Override
        public E ceiling(E e) {
            return treeMap.ceilingKey(e);
        }

        /**
         * 删除第一个元素（指定数量）
         * @param count 指定数量
         * @return 第一个元素
         */
        public E pollFirst(int count) {
            if (treeMap.isEmpty()) {
                return null;
            }
            E firstKey = treeMap.firstKey();
            remove(firstKey, count);
            return firstKey;
        }

        /**
         * 删除第一个元素(第一个元素有多个重复，仅删除其中一个)
         * @return 第一个元素
         */
        public E pollFirst() {
            return pollFirst(1);
        }

        /**
         * 删除第一个元素(包括所有数量)
         * @return 第一个元素
         */
        public E pollFirstAll() {
            // firstKey如果不存在可能会抛异常
            if (treeMap.isEmpty()) {
                return null;
            }

            E firstKey = treeMap.firstKey();
            size -= treeMap.get(firstKey);
            treeMap.remove(firstKey);
            return firstKey;
        }

        /**
         * 删除最后一个元素（若最后一个元素有多个重复，仅删除其中一个）
         * @return 最后一个元素
         */
        public E pollLast() {
            return pollLast(1);
        }

        /**
         * 删除最后一个元素（指定数量）
         * @param count 指定数量
         * @return 最后一个元素
         */
        public E pollLast(int count) {
            if (treeMap.isEmpty()) {
                return null;
            }
            E lastKey = treeMap.lastKey();
            remove(lastKey, count);
            return lastKey;
        }

        /**
         * 删除最后一个元素(包括所有数量)
         * @return 最后一个元素
         */
        public E pollLastAll() {
            if (treeMap.isEmpty()) {
                return null;
            }
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
        public Object clone() throws CloneNotSupportedException {
            TreeMultiSet<E> clone = (TreeMultiSet<E>) super.clone();
            clone.treeMap = new TreeMap<>(treeMap);
            return clone;
        }

    }

    class Data {
        int time;
        int idx;
        Data(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }

    class Interval {
        int s;
        int e;
        Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return s == interval.s && e == interval.e;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, e);
        }
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        TreeMultiSet<Interval> startQueue = new TreeMultiSet<>((o1, o2) -> o1.s == o2.s ? o1.e - o2.e : o1.s - o2.s);
        TreeMultiSet<Interval> endQueue = new TreeMultiSet<>((o1, o2) -> o1.e == o2.e ? o1.s - o2.s : o1.e - o2.e);
        for (int[] f : flowers) {
            Interval interval = new Interval(f[0], f[1]);
            startQueue.add(interval);
            endQueue.add(interval);
        }

        List<Data> list = new ArrayList<>();
        for (int i = 0; i < persons.length; i++) {
            list.add(new Data(persons[i], i));
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.time));

        int[] ansArr = new int[persons.length];
        int preAns = -1;
        for (int i = 0; i < list.size(); i++) {
            Data data = list.get(i);
            int time = data.time;
            int idx = data.idx;
            int removeCount = 0;
            while (!endQueue.isEmpty()) {
                Interval node = endQueue.first();
                if (node.e < time) {
                    if (i > 0 && node.s <= list.get(i-1).time) {
                        removeCount++;
                    }
                    endQueue.pollFirst();
                    startQueue.remove(node);
                } else {
                    break;
                }
            }

            int count = 0;
            while (!startQueue.isEmpty()) {
                Interval first = startQueue.first();
                if (first.s > time) {
                    break;
                }
                count++;
                startQueue.pollFirst();
            }
            ansArr[idx] = preAns == -1 ? count : count + preAns - removeCount;
            preAns = ansArr[idx];
        }
        return ansArr;
    }

    public static void main(String[] args) {
        int[] ansArr = new D().fullBloomFlowers(new int[][]{{19,37},{19,38},{19,35}}, new int[]{6,7,21,1,13,37,5,37,46,43});
    }

}
