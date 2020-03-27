package problem1201_1300;

public class Problem1246 {

    public int minimumMoves(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];

        // 单个字符也是回文串，删除单个字符的最小删除次数就是1
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int j = 1; j < len; j++) {
            for (int i = j-1; i >= 0; i--) {
                if (i == j - 1) {
                    // 就两个元素
                    dp[i][j] = arr[i] == arr[j] ? 1 : 2;
                    continue;
                }

                // 下面至少三个元素
                int min = Integer.MAX_VALUE;
                if (arr[i] == arr[j]) {
                    // 头尾相等，最小值有可能是出现在这对头尾最后被删的结果
                    min = dp[i+1][j-1];
                }

                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = min;
            }
        }

        return dp[0][len-1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1246().minimumMoves(new int[]{1,3,4,1,5}));
    }

}
