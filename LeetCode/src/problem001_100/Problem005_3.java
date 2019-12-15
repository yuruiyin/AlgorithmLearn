package problem001_100;

public class Problem005_3 {

    // 动态规划
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        char[] arr = s.toCharArray();
        int ansStart = 0;
        int ansEnd = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];  //  dp[l][r] 代表闭区间[l,r]是否是一个回文串

        // 一个字符就是一个回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (arr[l] == arr[r] && (r - l <= 2 || dp[l+1][r-1])) {
                    // 其中r-l <= 2代表[l,r]最多就三个字符，而头尾字符相等，那么[l,r]一定是回文串。
                    // 否则，如果字符大于三个的话，当前区间[l,r]要是回文串的前提是去除头尾字符后的子串要是回文串
                    dp[l][r] = true;
                    int len = r - l + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        ansStart = l;
                        ansEnd = r;
                    }
                }
            }
        }

        return s.substring(ansStart, ansEnd + 1);
    }

}
