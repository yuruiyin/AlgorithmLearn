package problem001_100;

public class Problem005_4 {

    // 利用最长公共子串，即字符串与反转后的字符串求最长公共子串就是最长回文串
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        char[] arr = s.toCharArray();
        int ansEnd = 0;
        int maxLen = 1;
        String reversedS = new StringBuilder(s).reverse().toString();
        char[] reversedArr = reversedS.toCharArray();
        int[][] dp = new int[n][n]; // dp[i][j]代表字符串s的第i个字符为结尾和reversedS的第j个字符为结尾的前面最长的公共子串的长度

        // 第0列
        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i] == reversedArr[0] ? 1 : 0;
        }

        // 第0行
        for (int j = 0; j < n; j++) {
            dp[0][j] = arr[0] == reversedArr[j] ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i] == reversedArr[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }

                if (dp[i][j] > maxLen && i - dp[i][j] + 1 + j == n - 1) {
                    maxLen = dp[i][j];
                    ansEnd = i;
                }
            }
        }

        return s.substring(ansEnd - maxLen + 1, ansEnd + 1);
    }

}
