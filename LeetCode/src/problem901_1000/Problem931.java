package problem901_1000;

import java.util.Arrays;

public class Problem931 {

    public int minFallingPathSum(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        int[] dp = new int[colCount];

        for (int j = 0; j < colCount; j++) {
            dp[j] = grid[rowCount - 1][j];
        }

        for (int i = rowCount - 2; i >= 0; i--) {
            int[] oldDp = Arrays.copyOf(dp, colCount);
            for (int j = 0; j < colCount; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = -1; k <= 1; k++) {
                    int curJ = j + k;
                    if (curJ < 0 || curJ >= colCount) {
                        continue;
                    }
                    min = Math.min(min, oldDp[curJ]);
                }

                dp[j] = grid[i][j] + min;
            }
        }

        int ansMin = Integer.MAX_VALUE;
        for (int num : dp) {
            ansMin = Math.min(ansMin, num);
        }

        return ansMin;
    }

    public static void main(String[] args) {
        System.out.println(new Problem931().minFallingPathSum(new int[][]{
                {51, 24},
                {-50, 82}
        }));
    }

}
