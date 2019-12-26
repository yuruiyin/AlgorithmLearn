package problem801_900;

public class Problem877_1 {

    private int[] piles;
    private Result[][] memo;

    class Result {
        int first;  // 先手最大值
        int second; // 后手最大值
        Result(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // dp[l][r].first = max(piles[l] + dp[l+1][r].second, dp[l][r-1].second + piles[r])
    // dp[l][r].second = max(dp[l+1][r].first, dp[l][r-1].first)
    private Result dp(int l, int r) {
        if (l == r) {
            return new Result(piles[l], 0);
        }

        if (memo[l][r] != null) {
            return memo[l][r];
        }

        Result result1 = dp(l+1, r);
        Result result2 = dp(l, r-1);
        int first;
        int second;
        if (piles[l] + result1.second > result2.second + piles[r]) {
            first = piles[l] + result1.second;
            second = result1.first;  // 因为先手选完，后手只能跟随先手。
        } else {
            first = result2.second + piles[r];
            second = result2.first;
        }

        memo[l][r] = new Result(first, second);
        return memo[l][r];
    }

    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        int len = piles.length;
        memo = new Result[len][len];
        Result result = dp(0, len - 1);
        return result.first > result.second;
    }

}
