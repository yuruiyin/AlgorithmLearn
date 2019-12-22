package problem1201_1300;

public class Problem1289 {

    private int[] getPrevRowMinArr(int[][] dp, int i) {
        int n = dp.length;
        int[] minArr = new int[n]; // 除自己之外的最小值
        // 先求最小的两个数
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int j = 0; j < n; j++) {
            if (dp[i][j] < min) {
                min = dp[i][j];
                minIndex = j;
            }
        }

        int secondMin = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (j != minIndex && dp[i][j] < secondMin) {
                secondMin = dp[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            if (j == minIndex) {
                minArr[j] = secondMin;
            } else {
                minArr[j] = min;
            }
        }

        return minArr;
    }

    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = arr[0][j];
        }

        // 记录上一行的每个位置除自己外的最小值
        int[] prevRowMinArr = getPrevRowMinArr(dp, 0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int prevRowMin = prevRowMinArr[j];
                dp[i][j] = prevRowMin + arr[i][j];
            }
            prevRowMinArr = getPrevRowMinArr(dp, i);
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n-1][j]);
        }

        return ans;
    }
   
    public static void main(String[] args) {
        
    }
    
}
