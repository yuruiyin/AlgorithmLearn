package problem301_400;

import java.util.Arrays;

public class Problem377 {

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[j] > i) {
                    break;
                }

                dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }

}
