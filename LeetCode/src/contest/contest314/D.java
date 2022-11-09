package contest.contest314;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[k][m + 1][n + 1];
        dp[0][0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int kk = 0; kk < k; kk++) {
                    int value = (kk + grid[i - 1][j - 1]) % k;
                    dp[value][i][j] = (dp[kk][i - 1][j] + dp[kk][i][j - 1]) % MOD;
                }
            }
        }
        return dp[0][m][n];
    }

}
