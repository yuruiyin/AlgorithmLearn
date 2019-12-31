package contest.contest088;

import java.util.*;

public class Problem850 {

    private static final int MOD = (int) (1e9 + 7);

    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class IntervalCmp implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        }
    }

    private List<Interval> mergeInterval(List<Interval> intervalList) {
        int size = intervalList.size();
        List<Interval> ansIntervalList = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            Interval curInterval = intervalList.get(i);
            Interval prevInterval = intervalList.get(i-1);
            if (curInterval.start == prevInterval.start) {
                continue;
            }

            if (curInterval.start < prevInterval.end) {
                curInterval.start = prevInterval.start;
                if (curInterval.end <= prevInterval.end) {
                    curInterval.end = prevInterval.end;
                }
            } else {
                // curInterval.start >= prevInterval.end，当前区间与前面区间没有交集
                ansIntervalList.add(prevInterval);
            }
        }

        ansIntervalList.add(intervalList.get(size - 1));
        return ansIntervalList;
    }

    private long calcArea(List<Interval> mergeYIntervalList, int xDiff) {
        long ySum = 0;
        for (Interval interval : mergeYIntervalList) {
            ySum += (interval.end - interval.start);
        }

        return ySum * xDiff;
    }

    public int rectangleArea(int[][] rectangles) {
        long areaSum = 0;
        Set<Integer> xSet = new TreeSet<>();

        // 将所有的x坐标放到一个集合中，并且排好序
        for (int[] rec : rectangles) {
            xSet.add(rec[0]);
            xSet.add(rec[2]);
        }

        List<Integer> xList = new ArrayList<>(xSet);
        int xSize = xList.size();

        // 遍历每个x区间，看看是否有矩形落入这个区间
        for (int i = 0; i < xSize - 1; i++) {
            List<Interval> yIntervalList = new ArrayList<>();
            for (int[] rec : rectangles) {
                if (rec[0] <= xList.get(i) && rec[2] >= xList.get(i+1)) {
                    yIntervalList.add(new Interval(rec[1], rec[3]));
                }
            }

            if (yIntervalList.isEmpty()) {
                continue;
            }

            // 区间排序
            yIntervalList.sort(new IntervalCmp());

            // 区间合并
            List<Interval> mergeYIntervalList = mergeInterval(yIntervalList);

            // 计算面积
            areaSum += calcArea(mergeYIntervalList, xList.get(i+1) - xList.get(i));
        }

        return (int) (areaSum % MOD);
    }

}
