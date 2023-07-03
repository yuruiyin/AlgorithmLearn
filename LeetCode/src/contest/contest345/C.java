package contest.contest345;

import java.util.Arrays;

public class C {

    private int[][] memo;

    private int rowCount;
    private int colCount;
    private int[][] grid;


    private int rec(int row, int col) {
        if (col == colCount - 1) {
            return 0;
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int ansMax = 0;
        for (int i = Math.max(0, row - 1); i <= Math.min(rowCount - 1, row + 1); i++) {
            if (grid[i][col + 1] > grid[row][col]) {
                ansMax = Math.max(ansMax, rec(i, col + 1) + 1);
            }
        }

        return  memo[row][col] = ansMax;
    }

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        memo = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(memo[i], -1);
        }

        int ansMax = 0;
        for (int i = 0; i < rowCount; i++) {
            ansMax = Math.max(ansMax, rec(i, 0));
        }
        return ansMax;
    }

}
