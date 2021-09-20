package contest.contest241;

import utils.CombinationInv;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/16
 */
public class D {

    private static final int MOD = (int) (1e9 + 7);
    private int[][] f;

    private int dp(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        }

        if (n == 0 || k == 0) {
            return 0;
        }

        if (f[n][k] != -1) {
            return f[n][k];
        }

        f[n][k] = (int) (((long) (n - 1) * dp(n - 1, k) + dp(n - 1, k - 1)) % MOD);
        return f[n][k];
    }

    public int rearrangeSticks(int n, int k) {
        f = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], -1);
        }
        return dp(n, k);
    }

}
