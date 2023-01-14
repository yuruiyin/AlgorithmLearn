package contest.contest323;

import java.util.*;

public class C {

    class Allocator {

        class Interval {
            int s;
            int e;
            Interval(int s, int e) {
                this.s = s;
                this.e = e;
            }
        }

        private List<Interval>[] id2Intervals;

        private TreeSet<Interval> intervals;

        private int n;

        public Allocator(int n) {
            id2Intervals = new ArrayList[1001];
            Arrays.setAll(id2Intervals, value -> new ArrayList<>());

            intervals = new TreeSet<>(new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.s - o2.s;
                }
            });
            this.n = n;
        }

        public int allocate(int size, int mID) {
            if (intervals.isEmpty()) {
                if (size > n) {
                    return -1;
                }

                Interval interval = new Interval(0, size - 1);
                id2Intervals[mID].add(interval);
                intervals.add(interval);
                return 0;
            }

            int i = 0;
            int lastE = -1;
            for (Interval interval : intervals) {
                if (i == 0) {
                    int s = interval.s;
                    if (s >= size) {
                        Interval interval1 = new Interval(0, size - 1);
                        id2Intervals[mID].add(interval1);
                        intervals.add(interval1);
                        return 0;
                    }
                } else {
                    if (interval.s - lastE - 1 >= size) {
                        Interval interval1 = new Interval(lastE + 1, lastE + size);
                        id2Intervals[mID].add(interval1);
                        intervals.add(interval1);
                        return lastE + 1;
                    }
                }
                lastE = interval.e;
                i++;
            }

            // 最后
            if (n - lastE - 1 >= size) {
                Interval interval1 = new Interval(lastE + 1, lastE + size);
                id2Intervals[mID].add(interval1);
                intervals.add(interval1);
                return lastE + 1;
            }

            return -1;
        }

        public int free(int mID) {
            List<Interval> removeIntervals = id2Intervals[mID];
            int count = 0;
            for (Interval interval: removeIntervals) {
                intervals.remove(interval);
                count += interval.e - interval.s + 1;
            }

            id2Intervals[mID].clear();
            return count;
        }
    }

}
