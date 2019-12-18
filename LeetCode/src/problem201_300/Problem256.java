package problem201_300;

public class Problem256 {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int rowCount = costs.length;
        int colCount = costs[0].length;
        int[][] dp = new int[rowCount][colCount];

        for (int j = 0; j < colCount; j++) {
            dp[0][j] = costs[0][j];
        }

        int[] prevRowMinArr = new int[colCount];
        prevRowMinArr[0] = Math.min(dp[0][1], dp[0][2]);
        prevRowMinArr[1] = Math.min(dp[0][0], dp[0][2]);
        prevRowMinArr[2] = Math.min(dp[0][0], dp[0][1]);

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                dp[i][j] = prevRowMinArr[j] + costs[i][j];
            }

            prevRowMinArr[0] = Math.min(dp[i][1], dp[i][2]);
            prevRowMinArr[1] = Math.min(dp[i][0], dp[i][2]);
            prevRowMinArr[2] = Math.min(dp[i][0], dp[i][1]);
        }

        int ansMin = Integer.MAX_VALUE;
        for (int j = 0; j < colCount; j++) {
            ansMin = Math.min(ansMin, dp[rowCount - 1][j]);
        }

        return ansMin;
    }

}
