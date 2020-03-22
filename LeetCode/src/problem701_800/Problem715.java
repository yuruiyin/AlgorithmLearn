package problem701_800;

import java.util.*;

/**
 * Problem715
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class Problem715 {

    static class RangeModule {

        class Interval {
            int left;
            int right;
            Interval(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        private TreeSet<Interval> intervals;

        public RangeModule() {
            intervals = new TreeSet<>(Comparator.comparingInt(o -> o.left));
        }

        public void addRange(int left, int right) {
            // 若当前区间与现有的区间存在交集，则需要合并区间
            intervals.add(new Interval(left, right));

            Interval pre = null;
            List<Interval> willRemoveIntervals = new ArrayList<>();
            for (Interval interval : intervals) {
                if (pre != null && interval.left <= pre.right) {
                    willRemoveIntervals.add(interval);
                    if (interval.right > pre.right) {
                        pre.right = interval.right;
                    }
                    continue;
                }

                pre = interval;
            }

            for (Interval interval : willRemoveIntervals) {
                intervals.remove(interval);
            }
        }

        public boolean queryRange(int left, int right) {
            for (Interval interval : intervals) {
                if (interval.left <= left && interval.right >= right) {
                    return true;
                }
            }

            return false;
        }

        public void removeRange(int left, int right) {
            Iterator<Interval> iterator = intervals.iterator();
            List<Interval> willRemoveIntervals = new ArrayList<>();
            List<Interval> willAddIntervals = new ArrayList<>();

            while (iterator.hasNext()) {
                Interval interval = iterator.next();
                if (interval.left >= right) {
                    break;
                }

                if (interval.right <= left) {
                    continue;
                }

                if (interval.left >= left && interval.right <= right) {
                    willRemoveIntervals.add(interval);
                } else if (interval.left < left && interval.right <= right) {
                    interval.right = left;
                } else if (interval.left < left && interval.right > right) {
                    // 分成两部分
                    willAddIntervals.add(new Interval(right, interval.right));
                    interval.right = left;
                    break;
                } else {
                    willRemoveIntervals.add(interval);
                    willAddIntervals.add(new Interval(right, interval.right));
                    break;
                }
            }

            for (Interval interval : willRemoveIntervals) {
                intervals.remove(interval);
            }

            intervals.addAll(willAddIntervals);
        }
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(27, 29);
        rangeModule.addRange(20, 25);
        rangeModule.removeRange(23, 28);
        rangeModule.addRange(10, 30);
        rangeModule.removeRange(6, 30);
        System.out.println(rangeModule.queryRange(16, 25));
        System.out.println(rangeModule.queryRange(13, 15));
        System.out.println(rangeModule.queryRange(16, 17));
    }

}
