package problem501_600;

import java.util.Arrays;

/**
 * Problem518_1
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class Problem518_1 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

}
