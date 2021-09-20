package contest.contest250;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/18
 */
public class C {

    private long[][] memo;
    private int m;
    private int n;
    private int[][] arr;

    private long dp(int i, int j) {
        if (i == m) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        long max = 0;
        for (int k = 0; k < n; k++) {
            
            max = Math.max(max, dp(i + 1, k) - Math.abs(j - k));
        }

        memo[i][j] = max + arr[i][j];
        return memo[i][j];
    }

    public long maxPoints(int[][] points) {
        long ansMax = 0;
        arr = points;
        m = arr.length;
        n = arr[0].length;
        memo = new long[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int j = 0; j < n; j++) {
            ansMax = Math.max(ansMax, dp(0, j));
        }
        return ansMax;
    }

}
