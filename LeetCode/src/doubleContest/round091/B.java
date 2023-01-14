package doubleContest.round091;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] %= MOD;
        }

        long ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dp[i];
        }
        return (int) (ans % MOD);
    }

}
