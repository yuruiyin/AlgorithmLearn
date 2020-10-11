package contest.contest207;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/20
 */
public class C {

    private static final int MOD = (int) (1e9 + 7);

    private int[][] grid;
    private int rowCount;
    private int colCount;
    private long ansMax = -1;
    private long[][] positive;
    private long[][] negative;
    private boolean[][] visited;

    private void rec(int row, int col, long tmpRes) {
        if (row >= rowCount || col >= colCount) {
            return;
        }

        if (row == rowCount - 1 && col == colCount - 1) {
            ansMax = Math.max(ansMax, tmpRes * grid[row][col]);
            return;
        }

        visited[row][col] = true;
        long nextRes = tmpRes * grid[row][col];
        if (visited[row][col]) {
            if (nextRes < 0 && nextRes >= negative[row][col]) {
                return;
            } else if (nextRes > 0 && nextRes <= positive[row][col]) {
                return;
            }
        }

        if (nextRes > 0) {
            positive[row][col] = nextRes;
        } else if (nextRes < 0) {
            negative[row][col] = nextRes;
        }

        rec(row + 1, col, nextRes);
        rec(row, col + 1, nextRes);
    }

    public int maxProductPath(int[][] grid) {
        this.grid = grid;
        this.rowCount = grid.length;
        this.colCount = grid[0].length;

        positive = new long[rowCount][colCount];
        negative = new long[rowCount][colCount];
        visited = new boolean[rowCount][colCount];
        rec(0, 0, 1);
        if (ansMax == -1) {
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    if (grid[i][j] == 0) {
                        return 0;
                    }
                }
            }

            return -1;
        }
        return (int) (ansMax % MOD);
    }

}
