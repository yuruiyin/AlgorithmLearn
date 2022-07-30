package contest.contest300;

import java.util.Arrays;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    private int[][] grid;
    private int rowCount;
    private int colCount;

    private long[][] memo;

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private long dp(int row, int col) {
        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        long ans = 1;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount || grid[nextRow][nextCol] <= grid[row][col]) {
                continue;
            }
            ans = (ans + dp(nextRow, nextCol)) % MOD;
        }

        memo[row][col] = ans;
        return ans;
    }

    public int countPaths(int[][] grid) {
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        this.grid = grid;
        memo = new long[rowCount][colCount];
        for (int i = 0;i < rowCount; i++) {
            Arrays.fill(memo[i], -1);
        }
        long ans = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                ans = (ans + dp(i, j)) % MOD;
            }
        }
        return (int) (ans % MOD);
    }

}
