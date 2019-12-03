package problem101_200;

import java.util.Arrays;

public class Problem198 {

    private int[] nums;
    private int len;
    private int[] memo;

    private int backTrack(int from) {
        if (from >= len) {
            return 0;
        }

        if (from == len - 1) {
            return nums[from];
        }

        if (memo[from] != -1) {
            return memo[from];
        }

        memo[from] = Math.max(nums[from] + backTrack(from + 2), nums[from+1] + backTrack(from + 3));
        return memo[from];
    }

    public int rob(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        memo = new int[len];
        Arrays.fill(memo, -1);
        return backTrack(0);
    }

}
