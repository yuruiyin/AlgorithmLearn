package contest.contest293;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class D {

    static class CountIntervals {

        class Interval {
            int left;
            int right;
            Interval(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        private TreeSet<Interval> treeSet;
        private int count;

        public CountIntervals() {
            treeSet = new TreeSet<>(new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.left == o2.left ? o2.right - o1.right : o1.left - o2.left;
                }
            });
            count = 0;
        }

        public void add(int left, int right) {
            // 寻找[left, right]之间的区间，进行合并
            Interval leftFloorInterval = treeSet.floor(new Interval(left, left));
            Interval leftCeilingInterval = treeSet.ceiling(new Interval(left, left));
            Interval rightFloorInterval = treeSet.floor(new Interval(right, right));
            if (leftCeilingInterval == null || leftCeilingInterval.left > right) {
                if (leftFloorInterval == null || leftFloorInterval.right < left) {
                    // 首次添加 或者添加在最右边
                    count += (right - left + 1);
                    treeSet.add(new Interval(left, right));
                } else {
                    treeSet.remove(leftFloorInterval);
                    count -= getLen(leftFloorInterval);
                    Interval addInterval = new Interval(leftFloorInterval.left, Math.max(right, leftFloorInterval.right));
                    treeSet.add(addInterval);
                    count += getLen(addInterval);
                }
            } else {
                if (leftFloorInterval == null || leftFloorInterval.right < left) {
                    Set<Interval> subSet = treeSet.subSet(leftCeilingInterval, true, rightFloorInterval, true);
                    Iterator<Interval> iterator = subSet.iterator();
                    while (iterator.hasNext()) {
                        Interval needRemoveInterval = iterator.next();
                        count -= getLen(needRemoveInterval);
                        iterator.remove();
                    }
                    Interval addInterval = new Interval(left, Math.max(rightFloorInterval.right, right));
                    count += getLen(addInterval);
                    treeSet.add(addInterval);
                } else {
                    Set<Interval> subSet = treeSet.subSet(leftFloorInterval, true, rightFloorInterval, true);
                    Iterator<Interval> iterator = subSet.iterator();
                    while (iterator.hasNext()) {
                        Interval needRemoveInterval = iterator.next();
                        count -= getLen(needRemoveInterval);
                        iterator.remove();
                    }
                    Interval addInterval = new Interval(leftFloorInterval.left, Math.max(rightFloorInterval.right, right));
                    count += getLen(addInterval);
                    treeSet.add(addInterval);
                }
            }
        }

        private int getLen(Interval interval) {
            return interval.right - interval.left  + 1;
        }

        public int count() {
            // 求区间的总长度
            return count;
        }

        public static void main(String[] args) {
            CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
            countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
            countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
            System.out.println(countIntervals.count());    // 返回 6
            // 整数 2 和 3 出现在区间 [2, 3] 中
            // 整数 7、8、9、10 出现在区间 [7, 10] 中
            countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
            System.out.println(countIntervals.count());    // 返回 8
            // 整数 2 和 3 出现在区间 [2, 3] 中
            // 整数 5 和 6 出现在区间 [5, 8] 中
            // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
            // 整数 9 和 10 出现在区间 [7, 10] 中
        }
    }

}
