package problem601_700;

import java.util.Arrays;
import java.util.Comparator;

public class Problem646 {

    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] dp = new int[len];
        dp[0] = 1;
        int ansMax = 1;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ansMax = Math.max(ansMax, dp[i]);
        }
        return ansMax;
    }

}
