import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

/**
 * LintCode1691_1
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode1691_1 {

    public int getAns(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // dp
        int len = arr.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        dp[1] = -arr[0];

        for (int i = 1; i < len; i++) {
            int[] newDp = new int[i + 2];
            Arrays.fill(newDp, Integer.MIN_VALUE);
            for (int j = i; j >= 0; j--) {
                if (dp[j] == Integer.MIN_VALUE) {
                    continue;
                }

                if (dp[j] - arr[i] > dp[j + 1]) {
                    newDp[j + 1] = dp[j] - arr[i];
                }

                if (j > 0 && dp[j] + arr[i] > dp[j - 1]) {
                    newDp[j - 1] = dp[j] + arr[i];
                }
            }

            for (int j = i + 1; j >= 0; j--) {
                if (newDp[j] != Integer.MIN_VALUE) {
                    dp[j] = newDp[j];
                }
            }
        }

        int ansMax = 0;
        for (int i = 0; i <= len; i++) {
            ansMax = Math.max(ansMax, dp[i]);
        }
        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new LintCode1691_1().getAns(new int[]{16,40,33,43,87,26,22,100,53,38,72,40,82,19,25,52,3,83}));
        System.out.println(new LintCode1691_1().getAns(new int[]{1, 2, 10, 9}));
    }

}
