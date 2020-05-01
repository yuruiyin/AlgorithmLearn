package contest.contest185;

import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/19
 */
public class D {

    private static final int MOD = 1000000007;

    private int n;
    private int m;
    private Long[][][] memo;

    private long dp(int preMax, int idx, int k) {
        if (idx == n) {
            return k == 0 ? 1 : 0;
        }

        if (k < 0) {
            return 0;
        }

        if (n - idx < k) {
            return 0;
        }

        if (preMax == m && k != 0) {
            return 0;
        }

        if (memo[preMax][idx][k] != null) {
            return memo[preMax][idx][k];
        }

        long ans = 0;
        for (int i = 1; i <= m; i++) {
            int max = preMax;
            int nextK = k;
            if (i > preMax) {
                max = i;
                nextK = k - 1;
            }

            ans = (ans + dp(max, idx + 1, nextK)) % MOD;
        }

        memo[preMax][idx][k] = ans;
        return ans;
    }

    public int numOfArrays(int n, int m, int k) {
        if (k == 0) {
            return 0;
        }

        this.n = n;
        this.m = m;

        memo = new Long[m + 1][n + 1][k + 1];

        return (int) (dp(0, 0, k) % MOD);
    }

}
