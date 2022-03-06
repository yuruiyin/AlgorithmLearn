package contest.contest272;

/**
 * A
 *
 * @author: yry
 * @date: 2021/12/19
 */
public class C {

    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int len = prices.length;
        long[] dp = new long[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        for (long num : dp) {
            ans += num;
        }
        return ans;
    }

}
