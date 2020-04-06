package problem401_500;

/**
 * Problem486
 *
 * @author: yry
 * @date: 2020/4/6
 */
public class Problem486 {

    private int[] nums;
    private Integer[][][] memo;

    private int dp(int l, int r, int player1) {
        if (l == r) {
            return player1 == 1 ? nums[l] : 0;
        }

        if (memo[l][r][player1] != null) {
            return memo[l][r][player1];
        }

        if (player1 == 1) {
            // 玩家1选
            int chooseLeft = nums[l] + dp(l + 1, r, 0);
            int chooseRight = nums[r] + dp(l, r - 1, 0);
            memo[l][r][player1] = Math.max(chooseLeft, chooseRight);
            return memo[l][r][player1];
        } else {
            // 玩家2选
            int chooseLeft = dp(l + 1, r, 1);
            int chooseRight = dp(l, r - 1, 1);
            memo[l][r][player1] = Math.min(chooseLeft, chooseRight);
            return memo[l][r][player1];
        }
    }

    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        this.nums = nums;
        int len = nums.length;
        memo = new Integer[len][len][2];
        int player1Score = dp(0, len - 1, 1);
        return player1Score >= sum - player1Score;
    }

}
