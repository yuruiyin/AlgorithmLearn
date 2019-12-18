package problem201_300;

import java.util.Arrays;
import java.util.Comparator;

public class Problem252 {

    public boolean canAttendMeetings(int[][] intervals) {
        // 判断区间是否相交
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int len = intervals.length;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }

        return true;
    }

}
