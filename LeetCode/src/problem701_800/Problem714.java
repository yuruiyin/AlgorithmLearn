package problem701_800;

import java.util.Arrays;

/**
 * Problem714
 *
 * @author: yry
 * @date: 2020/4/6
 */
public class Problem714 {

    private Integer[] memo;
    private int[] prices;
    private int len;
    private int fee;

    private int dp(int idx) {
        if (idx == len) {
            return 0;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        // 分两种选择，当前买入，或不买入
        int nonChooseRes = dp(idx + 1);
        int chooseRes = 0;
        int profit = 0;
        // 选择某一天卖出
        for (int i = idx + 1; i < len; i++) {
            int curProfit = prices[i] - prices[idx] - fee;
            if (curProfit <= profit) {
                continue;
            }
            int res = curProfit + dp(i + 1);
            profit = curProfit;
            chooseRes = Math.max(chooseRes, res);
        }

        memo[idx] = Math.max(nonChooseRes, chooseRes);
        return memo[idx];
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        this.prices = prices;
        this.len = prices.length;
        this.fee = fee;
        memo = new Integer[len];
        return dp(0);
    }

}
