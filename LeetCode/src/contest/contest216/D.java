package contest.contest216;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/22
 */
public class D {

    private boolean isOk(int[][] tasks, int init) {
        int left = init;
        for (int[] task : tasks) {
            int cost = task[0];
            int min = task[1];
            if (left < min) {
                return false;
            }

            left -= cost;
        }
        return true;
    }

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o2[0] - (o1[1] - o1[0]);
            }
        });

        // 二分
        int l = 0;
        int r = 1000000000;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(tasks, mid)) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
