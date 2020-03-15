package problem201_300;

import java.util.Arrays;

public class Problem300_1 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] > max) {
                    max = dp[j];
                }
            }

            dp[i] = max + 1;
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            ansMax = Math.max(ansMax, dp[i]);
        }
        return ansMax;
    }

}
