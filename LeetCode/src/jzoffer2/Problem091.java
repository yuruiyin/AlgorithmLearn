package jzoffer2;

public class Problem091 {

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i][j];
            }
        }
        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ansMin = Math.min(ansMin, dp[n - 1][i]);
        }
        return ansMin;
    }

}
