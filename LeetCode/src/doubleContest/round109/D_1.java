package doubleContest.round109;

import java.util.Arrays;

public class D_1 {

    private static final int MOD = (int) (1e9 + 7);

    private int x;
    private long[][] dp;

    private long pow(int x, int n) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= x;
        }
        return ans;
    }

    private long rec(int cur, int n) {
        if (n == 0) {
            return 1;
        }

        long powCur = pow(cur, x);
        if (powCur > n) {
            return -1;
        }

        if (powCur == n) {
            return 1;
        }

        if (dp[cur][n] != -1) {
            return dp[cur][n];
        }

        long chooseRes = rec(cur + 1, n - (int)powCur);
        long nonChooseRes = rec(cur + 1, n);

        long res = 0;
        if (chooseRes != -1) {
            res = (res + chooseRes) % MOD;
        }
        if (nonChooseRes != -1) {
            res = (res + nonChooseRes) % MOD;
        }

        return dp[cur][n] = res;
    }

    public int numberOfWays(int n, int x) {
        this.x = x;
        dp = new long[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int) (rec(1, n) % MOD);
    }

}
