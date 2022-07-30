package problem601_700;

import java.util.Arrays;

public class Problem698_1 {

    private int[] nums;
    private int eachSum;
    private int len;
    private Boolean[] memo;

    private boolean rec(int level, int firstSum, int k, int used) {
        if (k == 0) {
            return true;
        }

        if (memo[used] != null) {
            return memo[used];
        }

        int leftCount = len - level;
        if (leftCount < k) {
            memo[used] = false;
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > firstSum) {
                memo[used] = false;
                return false;
            }

            if ((used & (1 << i)) != 0) {
                continue;
            }

            boolean isOk;
            used |= (1 << i);
            if (nums[i] == firstSum) {
                isOk = rec(level + 1, eachSum, k - 1, used);
            } else {
                isOk = rec(level + 1, firstSum - nums[i], k, used);
            }
            if (isOk) {
                return true;
            }
            used ^= (1 << i);
        }
        memo[used] = false;
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        this.eachSum = sum / k;
        this.nums = nums;
        this.len = nums.length;
        Arrays.sort(nums);
        memo = new Boolean[1 << len];
        return rec(0, eachSum, k, 0);
    }

}
