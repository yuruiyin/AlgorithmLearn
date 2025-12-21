package contest.contest463;

import java.util.Arrays;
import java.util.LinkedList;

public class C {

    public long minArraySum(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }

        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;

        long[] best = new long[k];
        Arrays.fill(best, Long.MAX_VALUE / 2);
        best[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
            int mod = (int) (preSumArr[i] % k);
            dp[i] = Math.min(dp[i], best[mod]);
            best[mod] = Math.min(best[mod], dp[i]);
        }

        return (int) dp[n];
    }

}
