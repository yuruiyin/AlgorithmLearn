package doubleContest.round109;

import java.util.Arrays;
import java.util.Map;

public class C {

    private long[][] dp;

    private int[] nums;
    private int x;

    private int len;

    private long rec(int isOdd, int idx) {
        if (idx == len) {
            return 0;
        }

        if (dp[isOdd][idx] != -1) {
            return dp[isOdd][idx];
        }

        long chooseRes = rec(nums[idx] % 2, idx + 1) + (nums[idx] % 2 == isOdd ? nums[idx] : (nums[idx] - x));
        long nonChooseRes = rec(isOdd, idx + 1);

        return dp[isOdd][idx] = Math.max(chooseRes, nonChooseRes);
    }

    public long maxScore(int[] nums, int x) {
        this.len = nums.length;
        dp = new long[2][len];
        this.nums = nums;
        this.x = x;
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], -1);
        }

        return nums[0] + rec(nums[0] % 2, 1);
    }

}
