package problem501_600;

/**
 * Problem583
 *
 * @author: yry
 * @date: 2020/3/23
 */
public class Problem583 {

    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        }

        if (word2.isEmpty()) {
            return word1.length();
        }

        // 其实就是求最长公共子序列，然后用总个数-2*最长公共子序列的长度就是最少的删除字符数
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
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

        return len1 + len2 - 2 * dp[len1 - 1][len2 - 1];
    }

}
