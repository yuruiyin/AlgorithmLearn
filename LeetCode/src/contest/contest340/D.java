package contest.contest340;

import java.util.Arrays;
import java.util.Map;

public class D {

    private int[][] memo;

    private int rowCount;
    private int colCount;
    private int[][] grid;

    private int rec(int row, int col) {
        if (row == rowCount - 1 && col == colCount - 1) {
            return 1;
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        if (grid[row][col] == 0) {
            return Integer.MAX_VALUE;
        }

        int ansMin = Integer.MAX_VALUE;
        // 向右
        for (int nextCol = col + 1; nextCol <= grid[row][col] + col && nextCol < colCount; nextCol++) {
            int res = rec(row, nextCol);
            if (res == Integer.MAX_VALUE) {
                continue;
            }
            ansMin = Math.min(ansMin, res + 1);
        }
        // 向下
        for (int nextRow = row + 1; nextRow <= grid[row][col] + row && nextRow < rowCount; nextRow++) {
            int res = rec(nextRow, col);
            if (res == Integer.MAX_VALUE) {
                continue;
            }
            ansMin = Math.min(ansMin, res + 1);
        }

        return memo[row][col] = ansMin;
    }

    public int minimumVisitedCells(int[][] grid) {
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        this.grid = grid;
        memo = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = rec(0, 0);
        return ans == Integer.MAX_VALUE ? - 1: ans;
    }

}
