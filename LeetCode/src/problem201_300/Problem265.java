package problem201_300;

public class Problem265 {

    private void calcPrevRowMinArr(int[][] dp, int[] prevRowMinArr, int row) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int colCount = dp[0].length;
        for (int j = 0; j < colCount; j++) {
            if (dp[row][j] < min) {
                min = dp[row][j];
                minIndex = j;
            }
        }

        int secondMin = Integer.MAX_VALUE;
        for (int j = 0; j < colCount; j++) {
            if (j != minIndex && dp[row][j] < secondMin) {
                secondMin = dp[row][j];
            }
        }

        for (int j = 0; j < colCount; j++) {
            if (j != minIndex) {
                prevRowMinArr[j] = min;
            } else {
                prevRowMinArr[j] = secondMin;
            }
        }
    }

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int rowCount = costs.length;
        int colCount = costs[0].length;
        int[][] dp = new int[rowCount][colCount];
        int[] prevRowMinArr = new int[colCount];

        for (int j = 0; j < colCount; j++) {
            dp[0][j] = costs[0][j];
        }


        for (int i = 1; i < rowCount; i++) {
            calcPrevRowMinArr(dp, prevRowMinArr, i-1);
            for (int j = 0; j < colCount; j++) {
                dp[i][j] = prevRowMinArr[j] + costs[i][j];
            }
        }

        int ansMin = Integer.MAX_VALUE;
        for (int j = 0; j < colCount; j++) {
            if (dp[rowCount-1][j] < ansMin) {
                ansMin = dp[rowCount - 1][j];
            }
        }

        return ansMin;
    }

}
