package lcci;

public class Lcci0811_1 {

    private static final int MOD = (int) (1e9 + 7);

    public int waysToChange(int n) {
        if (n == 0) {
            return 1;
        }

        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 5, 10, 25};
        dp[0] = 1;

        for (int coin: coins) {
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Lcci0811_1().waysToChange(10));
    }

}
