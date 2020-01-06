package problem001_100;

public class Problem053_2 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1] < 0 ? nums[i] : dp[i-1] + nums[i];
        }

        int max = dp[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
