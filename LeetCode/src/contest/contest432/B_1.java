package contest.contest432;

public class B_1 {

    private static int MIN = -250000001;

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        if (m == 1 && n == 1) {
            return Math.max(0, coins[0][0]);
        }

        Integer[][][] dp = new Integer[m][n][3];
        dp[0][0][0] = MIN;
        dp[0][0][1] = Math.max(0, coins[0][0]);
        dp[0][0][2] = coins[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j][0] = Math.max(dp[0][j - 1][0] + coins[0][j], dp[0][j - 1][1]);
            dp[0][j][1] = Math.max(dp[0][j - 1][1] + coins[0][j], dp[0][j - 1][2]);
            dp[0][j][2] = dp[0][j - 1][2] + coins[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0] + coins[i][0], dp[i - 1][0][1]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1] + coins[i][0], dp[i - 1][0][2]);
            dp[i][0][2] = dp[i - 1][0][2] + coins[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][0] = Math.max(Math.max(dp[i - 1][j][0] + coins[i][j], dp[i - 1][j][1]), Math.max(dp[i][j - 1][0] + coins[i][j], dp[i][j - 1][1]));
                dp[i][j][1] = Math.max(Math.max(dp[i - 1][j][1] + coins[i][j], dp[i - 1][j][2]), Math.max(dp[i][j - 1][1] + coins[i][j], dp[i][j - 1][2]));
                dp[i][j][2] = Math.max(dp[i - 1][j][2] + coins[i][j], dp[i][j - 1][2] + coins[i][j]);
            }
        }

        return Math.max(Math.max(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1]), dp[m - 1][n - 1][2]);

    }

}
