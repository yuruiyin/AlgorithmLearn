package lcof;

public class Lcof059_1_1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int ansLen = nums.length - k + 1;
        int[] dp = new int[ansLen];

        for (int i = 0; i < k; i++) {
            dp[0] = Math.max(dp[0], nums[i]);
        }

        for (int i = 1; i < ansLen; i++) {
            if (dp[i-1] == nums[i-1]) {
                // 最大值是滑动窗口的第一个元素
                dp[i] = nums[i];
                for (int j = i; j < i + k; j++) {
                    dp[i] = Math.max(dp[i], nums[j]);
                }
            } else {
                dp[i] = Math.max(dp[i-1], nums[i + k - 1]);
            }
        }

        return dp;
    }

}
