package contest.contest400;

import java.util.Arrays;
import java.util.Comparator;

public class B {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        int pre = 0;
        int ans = 0;

        for (int[] m : meetings) {
            int s = m[0];
            int e = m[1];
            ans += Math.max(0, s - pre - 1);
            pre = Math.max(pre, e);
        }

        ans += days - pre;
        return ans;
    }

}
