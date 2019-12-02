package contest.contest165;

public class Problem03 {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // dp数组代表以当前元素为正方形的右下角的最大正方形边长（假设为count, 那么以该元素为正方形右下角就会生成count个正方形）
        int[][] dp = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                ans++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 1 && dp[0][j] == 0) {
                dp[0][j] = 1;
                ans++;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                // 以当前元素为正方形右下角的最大正方形边长计算公式
                dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                ans += dp[i][j];
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem03().countSquares(new int[][]{
                {1,0,1},{1,1,0},{1,1,0}
        }));
    }
    
}
