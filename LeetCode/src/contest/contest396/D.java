package contest.contest396;

import java.util.Arrays;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        if (len == 2) {
            if (nums[0] == nums[1]) {
                return 0;
            }
            return (int) (((long) Math.abs(nums[0] - nums[1]) * cost1) % MOD);
        }

        long max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        if (cost1 * 2 <= cost2) {
            return (int) ((max * len - sum) * cost1 % MOD);
        }

        Arrays.sort(nums);
        long left = max * len - sum;
        if (left % 2 == 0) {
            // todo 看非max的个数是否不止一个

        } else {

        }

        return -1;
    }

}
