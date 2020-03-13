package lcci;

import java.util.Arrays;

public class Lcci0814_2 {

    private char[] arr;
    private int len;
    private int[] dp;

    private int getBoolAns(int val1, int val2, char operator) {
        if (operator == '&') {
            return val1 & val2;
        } else if (operator == '|') {
            return val1 | val2;
        }
        return val1 ^ val2;
    }

    /**
     * 返回从索引start到end值为result的不同括号方案的个数
     */
    private int rec(int start, int end, int result) {
        if (start == end) {
            return arr[start] - '0' == result ? 1 : 0;
        }

        int key = result * len * len + start * len + end;
        if (dp[key] != -1) {
            return dp[key];
        }

        dp[key] = 0;
        for (int k = start; k < end; k+=2) {
            char operator = arr[k + 1];
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (getBoolAns(i, j, operator) == result) {
                        dp[key] += rec(start, k, i) * rec(k + 2, end, j);
                    }
                }
            }
        }

        return dp[key];
    }

    public int countEval(String s, int result) {
        arr = s.toCharArray();
        len = arr.length;
        dp = new int[len * len * 2];
        Arrays.fill(dp, -1);
        return rec(0, len - 1, result);
    }

}
