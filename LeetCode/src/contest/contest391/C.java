package contest.contest391;

public class C {

    public long countAlternatingSubarrays(int[] nums) {
        int len = nums.length;
        long[] dp = new long[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        long ans = 0;
        for (int i = 0; i < len; i++) {
            ans += dp[i];
        }
        return ans;
    }

}
