package doubleContest.round137;

public class C_1 {

    private int[][] grid;

    private int m;
    private int n;

    private Long[][][] memo;

    private long dp(int row, int preCol1, int preCol2) {
        if (memo[row][preCol1][preCol2] != null) {
            return memo[row][preCol1][preCol2];
        }

        if (row == m - 1) {
            int count = 0;
            if (preCol1 != n) {
                count++;
            }
            if (preCol2 != n) {
                count++;
            }
            if (count < 2) {
                return (long) -4e9;
            }

            long max = (long) -1e9;
            for (int j = 0; j < n; j++) {
                if (j == preCol1 ||j == preCol2) {
                    continue;
                }
                max = Math.max(max, grid[row][j]);
            }

            return memo[row][preCol1][preCol2] = max;
        }

        if (preCol1 != n && preCol2 != n) {
            // 选最后一个
            long lastMax = (long) -1e9;
            for (int i = row; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == preCol1 || j == preCol2) {
                        continue;
                    }
                    lastMax = Math.max(lastMax, grid[i][j]);
                }
            }
            return memo[row][preCol1][preCol2] = lastMax;
        }

        // 选这行或者不选这行
        long chooseRes = (long) -4e9;
        for (int j = 0; j < n; j++) {
            if (j == preCol1 || j == preCol2) {
                continue;
            }
            long tmpRes = 0;
            if (preCol1 == n) {
                tmpRes = dp(row + 1, j, preCol2);
            } else if (preCol2 == n) {
                tmpRes = dp(row + 1, preCol1, j);
            }

            if (tmpRes != -4e9) {
                tmpRes += grid[row][j];
                chooseRes = Math.max(chooseRes, tmpRes);
            }
        }

        long nonChooseRes = dp(row + 1, preCol1, preCol2);
        return memo[row][preCol1][preCol2] = Math.max(chooseRes, nonChooseRes);
    }

    public long maximumValueSum(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        memo = new Long[m][n + 1][n + 1];
        return dp(0, n, n);
    }

}
