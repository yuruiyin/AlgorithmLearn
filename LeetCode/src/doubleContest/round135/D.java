package doubleContest.round135;

public class D {

    private int m;
    private int n;
//    private int[][] grid;

    private long[][] colPreSumArr;

    private Long[][][] memo;

    private long dp(int colIdx, int preBlack, int preRowIdx) {
        if (colIdx == n) {
            return 0;
        }

        if (memo[colIdx][preBlack][preRowIdx] != null) {
            return memo[colIdx][preBlack][preRowIdx];
        }

        // 选 或 不选
        long chooseRes = 0;
        for (int row = 0; row < m; row++) {
            long cost = 0;
            int nextPreRowIdx = row;
            if (preBlack == 0) {
                // 前面是白色
                if (colIdx > 0) {
                    if (preRowIdx == m) {
                        // 说明前面白色没统计过
                        cost = colPreSumArr[row][colIdx - 1];
                    } else {
                        // 前面白色统计到preRowIdx
                        if (row > preRowIdx) {
                            cost = colPreSumArr[row][colIdx - 1] - colPreSumArr[preRowIdx][colIdx - 1];
                        } else {
                            nextPreRowIdx = preRowIdx;
                        }
                    }
                }
            } else {
                // 前面是黑色
                if (row >= preRowIdx) {
                    cost = colPreSumArr[row][colIdx - 1] - colPreSumArr[preRowIdx][colIdx - 1];
                } else {
                    cost = colPreSumArr[preRowIdx][colIdx] - colPreSumArr[row][colIdx];
                    nextPreRowIdx = preRowIdx;
                }
            }
            chooseRes = Math.max(chooseRes, cost + dp(colIdx + 1, 1, nextPreRowIdx));
        }

        long nonChooseRes = 0;
        if (preBlack == 0) {
            // 前面是白色
            nonChooseRes = dp(colIdx + 1, 0, m);
        } else {
            // 前面是黑色
            long cost = colPreSumArr[preRowIdx][colIdx];
            nonChooseRes = cost + dp(colIdx + 1, 0, preRowIdx);
        }

        return memo[colIdx][preBlack][preRowIdx] = Math.max(chooseRes, nonChooseRes);
    }

    public long maximumScore(int[][] grid) {
//        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        colPreSumArr = new long[m][n];
        colPreSumArr[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            colPreSumArr[i][0] = colPreSumArr[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            colPreSumArr[0][j] = grid[0][j];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                colPreSumArr[i][j] = colPreSumArr[i - 1][j] + grid[i][j];
            }
        }

        memo = new Long[n + 1][2][m + 1];
        return dp(0, 0, m);
    }

}
