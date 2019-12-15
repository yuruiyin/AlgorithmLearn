package doubleContest.round15;

import java.util.Arrays;
import java.util.Comparator;

public class Problem02_1 {

    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;

        if (len == 1) {
            return 1;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        int leftRight = intervals[0][1];
        int removeCount = 0;
        for (int i = 1; i < len; i++) {
            if (intervals[i][1] <= leftRight) {
                removeCount++;
            } else {
                leftRight = intervals[i][1];
            }
        }

        return len - removeCount;
    }

}
