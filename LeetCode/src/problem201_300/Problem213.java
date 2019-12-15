package problem201_300;

public class Problem213 {

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        dp[n-1][0] = Math.max(dp[n-2][0], dp[n-2][1]);

        // 求最后一个房间被盗的最大值，那么第一个就不能被盗，这样需要重新计算dp
        dp[1][0] = 0;
        dp[1][1] = nums[1];

        for (int i = 2; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        dp[n-1][1] = dp[n-2][0] + nums[n-1];

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

}
