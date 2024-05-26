package contest.contest399;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int len = nums.length;
        if (len == 1) {
            long ans = 0;
            for (int[] q : queries) {
                int pos = q[0];
                nums[pos] = q[1];
                ans = (ans + Math.max(nums[pos], 0)) % MOD;
            }
            return (int) ans;
        }

        int[] dp = new int[len];
        dp[0] = Math.max(nums[0], 0);
        dp[1] = Math.max(nums[0], Math.max(0, nums[1]));
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        long ans = 0;
        for (int[] q : queries) {
            int pos = q[0];
            nums[pos] = q[1];
            if (pos == 0) {
                dp[pos] = Math.max(nums[pos], 0);
            } else if (pos == 1) {
                dp[pos] = Math.max(nums[0], Math.max(0, nums[pos]));
            } else {
                dp[pos] = Math.max(dp[pos - 1], dp[pos - 2] + nums[pos]);
            }

            for (int i = pos + 1; i < len; i++) {
                if (i == 1) {
                    dp[i] = Math.max(nums[0], Math.max(0, nums[1]));
                } else {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                }
            }

            ans = (ans + Math.max(dp[len - 1], dp[len - 2])) % MOD;
        }

        return (int) ans;
    }

}
