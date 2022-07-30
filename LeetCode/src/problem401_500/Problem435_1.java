package problem401_500;

import java.util.Arrays;
import java.util.Comparator;

public class Problem435_1 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        // 求最长无重叠区间个数，先按右端点从小到大排序，然后每次用左端点跟上一次的右端点进行对比，不重叠则count+1
        int count = 1;
        int right = intervals[0][1];
        int len = intervals.length;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= right) {
                count++;
                right = intervals[i][1];
            }
        }
        return len - count;
    }

}
