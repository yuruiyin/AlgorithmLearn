package problem201_300;

public class Problem221 {

    public int maximalSquare(char[][] matrix) {
        // dp
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] dp = new int[rowCount][colCount];  // 最大边长
        int maxSideLen = 0;

        for (int i = 0; i < rowCount; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (dp[i][0] > maxSideLen) {
                maxSideLen = dp[i][0];
            }
        }

        for (int j = 0; j < colCount; j++) {
            dp[0][j] = matrix[0][j] - '0';
            if (dp[0][j] > maxSideLen) {
                maxSideLen = dp[0][j];
            }
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;

                if (dp[i][j] > maxSideLen) {
                    maxSideLen = dp[i][j];
                }
            }
        }

        return maxSideLen * maxSideLen;
    }

}
