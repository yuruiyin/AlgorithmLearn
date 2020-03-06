package problem301_400;

import java.util.Arrays;

public class Problem377_1 {

    private int[] nums;
    private int len;
    private int[] memo;

    private int dp(int target) {
        if (target == 0) {
            return 1;
        }

        if (memo[target] != -1) {
            return memo[target];
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > target) {
                break;
            }

            ans += dp(target - nums[i]);
        }

        memo[target] = ans;
        return ans;
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        len = nums.length;
        this.nums = nums;
        Arrays.sort(nums);
        memo = new int[target+1];
        Arrays.fill(memo, -1);
        return dp(target);
    }

}
