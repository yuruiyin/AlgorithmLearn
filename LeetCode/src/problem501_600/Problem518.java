package problem501_600;

import java.util.Arrays;

/**
 * Problem518
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class Problem518 {

    private int[] coins;
    private int len;
    private int[][] memo;

    private int dp(int idx, int amount) {
        if (amount == 0) {
            return 1;
        }

        if (idx == len) {
            return 0;
        }

        if (coins[idx] > amount) {
            return 0;
        }

        if (memo[idx][amount] != -1) {
            return memo[idx][amount];
        }

        int ans = 0;
        for (int i = amount / coins[idx]; i >= 0; i--) {
            ans += dp(idx + 1, amount - i * coins[idx]);
        }

        memo[idx][amount] = ans;
        return ans;
    }

    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.len = coins.length;
        memo = new int[len][amount + 1];
        Arrays.sort(coins);
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, amount);
    }

}
