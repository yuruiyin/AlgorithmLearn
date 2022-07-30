package jzoffer2;

import java.util.Arrays;

public class Problem091_1 {

    private int[][] memo;
    private int n;
    private int[][] costs;

    private int dp(int i, int color) {
        if (i == n) {
            return 0;
        }
        if (memo[i][color] != -1) {
            return memo[i][color];
        }

        int ansMin = Integer.MAX_VALUE;
        for (int nextColor = 0; nextColor < 3; nextColor++) {
            if (nextColor == color) {
                continue;
            }
            ansMin = Math.min(ansMin, costs[i][color] + dp(i + 1, nextColor));
        }

        memo[i][color] = ansMin;
        return ansMin;
    }

    public int minCost(int[][] costs) {
        n = costs.length;
        this.costs = costs;

        int ansMin = Integer.MAX_VALUE;
        memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int color = 0; color < 3; color++) {
            ansMin = Math.min(ansMin, dp(0, color));
        }
        return ansMin;
    }

}
