package problem701_800;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem757
 *
 * @author: yry
 * @date: 2020/4/17
 */
public class Problem757 {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });

        int len = intervals.length;
        int first = intervals[0][1] - 1;
        int second = intervals[0][1];
        int ans = 2;

        for (int i = 1; i < len; i++) {
            int[] curInterval = intervals[i];
            if (curInterval[1] == intervals[i-1][1]) {
                continue;
            }

            int start = curInterval[0];
            int end = curInterval[1];
            if (first >= start) {
                continue;
            }
            if (second >= start) {
                // 当前区间有一个与前面有交集
                first = second;
                second = end;
                ans++;
            } else {
                first = end - 1;
                second = end;
                ans += 2;
            }
        }

        return ans;
    }

}
