package doubleContest.round092;

import java.util.Arrays;

public class D_1 {

    private static final int MOD = (int) (1e9 + 7);

    private long rec(int i, int j, int[][] dp, char[] arr, char[] subArr) {
        if (j == 5) {
            return 1;
        }

        if (arr.length - i < 5 - j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (arr[i] != subArr[j]) {
            return rec(i + 1, j, dp, arr, subArr);
        }

        // 相等有两种选择，算和不算
        long chooseRes = rec(i + 1, j + 1, dp, arr, subArr);
        long nonChooseRes = rec(i + 1, j, dp, arr, subArr);
        return dp[i][j] = (int) ((chooseRes + nonChooseRes) % MOD);
    }

    private long calcCount(char[] arr, char[] subArr) {
        if (!checkIsSubSeq(arr, subArr)) {
            return 0;
        }
        int[][] dp = new int[arr.length][subArr.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(0, 0, dp, arr, subArr);
    }

    private boolean checkIsSubSeq(char[] arr, char[] subArr) {
        int len = arr.length;
        int subLen = subArr.length;
        int j = 0;
        for (int i = 0; i < len && j < subLen && len - i >= subLen - j; ) {
            if (arr[i] == subArr[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == subLen;
    }

    public int countPalindromes(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        if (len < 5) {
            return 0;
        }

        long ans = 0;
        for (int i = 0; i <= 999; i++) {
            String tmpStr = String.format("%03d", i);
            String prefixStr = tmpStr.substring(0, 2);
            String subStr = tmpStr + new StringBuilder(prefixStr).reverse();
            ans = (ans + calcCount(arr, subStr.toCharArray())) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new D_1().countPalindromes("0000000"));
        System.out.println(new D_1().countPalindromes("0".repeat(10000)));
    }

}
