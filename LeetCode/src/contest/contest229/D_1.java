package contest.contest229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/21
 */
public class D_1 {

    private char[] arr1;
    private char[] arr2;
    private int len1;
    private int len2;

    public int longestPalindromeSubseq(char[] arr, int l, int r) {
        int n = r - l + 1;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i + l] == arr[j + l]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int longestPalindrome(String word1, String word2) {
        arr1 = word1.toCharArray();
        arr2 = word2.toCharArray();
        this.len1 = arr1.length;
        this.len2 = arr2.length;

        List<Integer>[] indexListArr1 = new ArrayList[26];
        List<Integer>[] indexListArr2 = new ArrayList[26];

        for (int i = 0; i < len1; i++) {
            if (indexListArr1[arr1[i] - 'a'] == null) {
                indexListArr1[arr1[i] - 'a'] = new ArrayList<>();
            }
            indexListArr1[arr1[i] - 'a'].add(i);
        }

        for (int i = 0; i < len2; i++) {
            if (indexListArr2[arr2[i] - 'a'] == null) {
                indexListArr2[arr2[i] - 'a'] = new ArrayList<>();
            }
            indexListArr2[arr2[i] - 'a'].add(i);
        }

        String merge = word1 + word2;
        char[] arr = merge.toCharArray();
        int ansMax = 0;

        for (int i = 0; i < 26; i++) {
            if (indexListArr1[i] == null || indexListArr2[i] == null) {
                continue;
            }

            int l = indexListArr1[i].get(0) + 1;
            int r = indexListArr2[i].get(indexListArr2[i].size() - 1) - 1 + len1;
            ansMax = Math.max(ansMax, longestPalindromeSubseq(arr, l, r) + 2);
        }

        return ansMax;


    }

}
