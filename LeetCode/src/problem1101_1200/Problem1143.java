package problem1101_1200;

/**
 * 最长公共子序列(LCS)二维dp版本
 *
 * @author: yry
 * @date: 2020/3/23
 */
public class Problem1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[][] dp = new int[len1][len2];
        dp[0][0] = arr1[0] == arr2[0] ? 1 : 0;

        for (int i = 1; i < len1; i++) {
            dp[i][0] = arr1[i] == arr2[0] ? 1 : dp[i-1][0];
        }

        for (int j = 1; j < len2; j++) {
            dp[0][j] = arr1[0] == arr2[j] ? 1 : dp[0][j-1];
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j] = arr1[i] == arr2[j] ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[len1 - 1][len2 - 1];
    }

}
