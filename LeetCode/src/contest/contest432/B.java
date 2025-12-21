package contest.contest432;

public class B {

    private static int MIN = -250000001;

    private Integer[][][] dp;

    private int m;
    private int n;
    private int[][] coins;

    private int getCoin(int row, int col, int leftCount) {
        int coin = coins[row][col];
        if (coin >= 0) {
            return coin;
        }
        return leftCount > 0 ? 0 : -coin;
    }

    private int rec(int row, int col, int leftCount) {
        int coin = coins[row][col];
        if (row == m - 1 && col == n - 1) {
            if (coin >= 0) {
                return coin;
            }
            return leftCount > 0 ? 0 : -coin;
        }

        if (dp[row][col][leftCount] != null) {
            return dp[row][col][leftCount];
        }

        int resMax;
        if (coin >= 0 || leftCount == 0) {
            int bottomRes = MIN;
            if (row < m - 1) {
                bottomRes = rec(row + 1, col, leftCount);
            }
            int rightRes = MIN;
            if (col < n - 1) {
                rightRes = rec(row, col + 1, leftCount);
            }
            resMax = coin + Math.max(bottomRes, rightRes);
        } else {
            int useCountBottomRes = MIN;
            if (row < m - 1) {
                useCountBottomRes = rec(row + 1, col, leftCount - 1);
            }
            int useCountRightRes = MIN;
            if (col < n - 1) {
                useCountRightRes = rec(row, col + 1, leftCount - 1);
            }

            int noneUseCountBottomRes = MIN;
            if (row < m - 1) {
                noneUseCountBottomRes = rec(row + 1, col, leftCount) + coin;
            }
            int noneUseCountRightRes = MIN;
            if (col < n - 1) {
                noneUseCountRightRes = rec(row, col + 1, leftCount) + coin;
            }

            resMax = Math.max(Math.max(useCountBottomRes, useCountRightRes), Math.max(noneUseCountBottomRes, noneUseCountRightRes));
        }

        return dp[row][col][leftCount] = resMax;
    }

    public int maximumAmount(int[][] coins) {
        this.m = coins.length;
        this.n = coins[0].length;
        this.coins = coins;
        if (m == 1 && n == 1) {
            return Math.max(0, coins[0][0]);
        }

        dp = new Integer[m][n][3];
        return rec(0, 0, 2);
    }

}
