package problem501_600;

import java.util.Arrays;

public class Problem516_1 {

    private Integer[][] memo;

    private char[] arr;

    private int dp(int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return 1;
        }

        if (l == r - 1) {
            // 两个数
            if (arr[l] == arr[r]) {
                return 2;
            }
            return 1;
        }

        if (memo[l][r] != null) {
            return memo[l][r];
        }

        if (arr[l] == arr[r]) {
            memo[l][r] = 2 + dp(l + 1, r - 1);
            return memo[l][r];
        }

        int ansMax = Math.max(dp(l, r - 1), dp(l + 1, r));
        memo[l][r] = ansMax;
        return ansMax;
    }

    public int longestPalindromeSubseq(String s) {
        arr = s.toCharArray();
        int len = arr.length;
        memo = new Integer[len][len];
        return dp(0, len - 1);
    }

}
