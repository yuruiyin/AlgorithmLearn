package problem701_800;

import java.util.Arrays;

public class Problem741 {

    private int[][] getDp(int[][] grid, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = grid[0][0] == 1 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == -1) {
                break;
            }
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            if (grid[0][j] == -1) {
                break;
            }
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == -1) {
                    continue;
                }
                if (dp[i - 1][j] == -1 && dp[i][j - 1] == -1) {
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            return grid[0][0] == 1 ? 1 : 0;
        }

        int[][] dp = getDp(grid, n);
        if (dp[n - 1][n - 1] == -1) {
            return 0;
        }
        int ansCount = dp[n - 1][n - 1];
        // 从[n - 1, n - 1]出发找一个最长路径，然后经历过的格子置为0
        int r = n - 1;
        int c = n - 1;
        grid[r][c] = 0;
        grid[0][0] = 0;
        while (true) {
            if (r == 0 && c == 0) {
                break;
            }

            if (r == 0) {
                grid[r][c - 1] = 0;
                c--;
            } else if (c == 0) {
                grid[r - 1][c] = 0;
                r--;
            } else {
                if (dp[r - 1][c] >= dp[r][c - 1]) {
                    grid[r - 1][c] = 0;
                    r--;
                } else {
                    grid[r][c - 1] = 0;
                    c--;
                }
            }
        }

        int[][] dp1 = getDp(grid, n);
        return ansCount + dp1[n - 1][n - 1];
    }

    public static void main(String[] args) {
//        System.out.println(new Problem741().cherryPickup(new int[][]{
//                {1,1,-1},{1,-1,1},{-1,1,1}
//        }));
        System.out.println(new Problem741().cherryPickup(new int[][]{
                {1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}
        }));
    }

}
