package jzoffer2;

import java.util.Arrays;

public class Problem091_2 {

    private int[][] memo;
    private int n;
    private int[][] costs;

    private int dp(int i, int preColor) {
        if (i == n) {
            return 0;
        }
        if (memo[i][preColor] != -1) {
            return memo[i][preColor];
        }

        int ansMin = Integer.MAX_VALUE;
        for (int curColor = 1; curColor <= 3; curColor++) {
            if (curColor == preColor) {
                continue;
            }
            ansMin = Math.min(ansMin, costs[i][curColor - 1] + dp(i + 1, curColor));
        }

        memo[i][preColor] = ansMin;
        return ansMin;
    }

    public int minCost(int[][] costs) {
        n = costs.length;
        this.costs = costs;

        memo = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0);
    }

}
