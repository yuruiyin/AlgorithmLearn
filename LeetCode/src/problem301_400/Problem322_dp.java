package problem301_400;

public class Problem322_dp {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int n = coins.length;
        if (n == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Problem322_dp().coinChange(new int[]{1,2,5}, 11));
        System.out.println(new Problem322_dp().coinChange(new int[]{2}, 3));
        System.out.println(new Problem322_dp().coinChange(new int[]{1,2,5}, 100000000));
    }
    
}
