package contest.contest397;

import java.util.*;

public class C {

    private int[][] grid;
    private int m;
    private int n;

    private Integer[][][] memo;

    private int dp(int r, int c, int hasGo) {
        if (memo[r][c][hasGo] != null) {
            return memo[r][c][hasGo];
        }

        // 向右
        int resRight = hasGo == 1 ? 0 : (int) -1e5;
        for (int j = c + 1; j < n; j++) {
            resRight = Math.max(resRight, grid[r][j] - grid[r][c] + dp(r, j, 1));
        }

        // 向下
        int resBottom = hasGo == 1 ? 0 : (int) -1e5;
        for (int i = r + 1; i < m; i++) {
            resBottom = Math.max(resBottom, grid[i][c] - grid[r][c] + dp(i, c, 1));
        }

        return memo[r][c][hasGo] = Math.max(resRight, resBottom);
    }

    public int maxScore(List<List<Integer>> list) {
        m = list.size();
        n = list.get(0).size();
        grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = list.get(i).get(j);
            }
        }

        memo = new Integer[m][n][2];
        int ansMax = (int) -1e5;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                ansMax = Math.max(ansMax, dp(i, j, 0));
            }
        }

        return ansMax;
    }

}
