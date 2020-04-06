package problem001_100;

public class Problem072 {

    // 思路：类似最长公共子序列
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        if (len1 == 0) {
            return len2;
        }

        if (len2 == 0) {
            return len1;
        }

        int[][] dp = new int[len1][len2];
        dp[0][0] = arr1[0] == arr2[0] ? 0 : 1;

        for (int i = 1; i < len1; i++) {
            if (arr2[0] != arr1[i]) {
                dp[i][0] = dp[i-1][0] + 1;
            } else {
                dp[i][0] = i;
            }
        }

        for (int j = 1; j < len2; j++) {
            if (arr1[0] != arr2[j]) {
                dp[0][j] = dp[0][j-1] + 1;
            } else {
                dp[0][j] = j;
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + 1);
                }
            }
        }

        return dp[len1-1][len2-1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem072().minDistance("horse", "ros"));
        System.out.println(new Problem072().minDistance("intention", "execution"));
        System.out.println(new Problem072().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));

    }
    
}
