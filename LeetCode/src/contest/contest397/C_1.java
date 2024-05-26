package contest.contest397;

import java.util.List;

public class C_1 {

    public int maxScore(List<List<Integer>> list) {
        int m = list.size();
        int n = list.get(0).size();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = list.get(i).get(j);
            }
        }

        int ansMax = (int) -1e5;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int preMin = Math.min((i == 0 ? 100000 : dp[i - 1][j]), (j == 0 ? 100000 : dp[i][j - 1]));
                ansMax = Math.max(ansMax, grid[i][j] - preMin);
                dp[i][j] = Math.min(preMin, grid[i][j]);
            }
        }
        return ansMax;
    }

}
