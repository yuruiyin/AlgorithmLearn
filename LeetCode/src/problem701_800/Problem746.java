package problem701_800;

public class Problem746 {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = cost[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i];
        }

        return Math.min(dp[len-1][0], dp[len-1][1]);
    }

}
