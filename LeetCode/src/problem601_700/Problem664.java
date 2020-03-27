package problem601_700;

import java.util.Arrays;

/**
 * Problem664 区间dp
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class Problem664 {

    private char[] arr;
    private int[][] memo;

    private int dp(int i, int j) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int ans = dp(i + 1, j) + 1;
        for (int k = i + 1; k <= j; k++) {
            if (arr[k] == arr[i]) { // 找到一个与当前区间的第一个字符相等，则可以当成这个字符后面与第一个字符一起删
                ans = Math.min(ans, dp(i, k - 1) + dp(k + 1, j));
            }
        }

        memo[i][j] = ans;
        return ans;
    }

    public int strangePrinter(String s) {
        this.arr = s.toCharArray();
        int len = s.length();
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, len - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Problem664().strangePrinter("aaabbb"));
//        System.out.println(new Problem664().strangePrinter("aba"));
    }

}
