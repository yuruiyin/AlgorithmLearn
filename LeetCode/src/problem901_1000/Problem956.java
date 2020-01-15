package problem901_1000;

public class Problem956 {

    private int[] rods;
    private int len;
    private Integer[][] memo;

    private int dp(int idx, int sum) {
        if (idx == len) {
            return sum == 5000 ? 0 : Integer.MIN_VALUE;
        }

        if (memo[idx][sum] != null) {
            return memo[idx][sum];
        }

        // 注意：分到左侧，和分到右侧的时候，只要保证一加一减即可。因为目标是让sum等于初始sum。
        int nonChoose = dp(idx + 1, sum); // 不选
        int chooseToLeft = rods[idx] + dp(idx + 1, sum - rods[idx]); // 选到左侧
        int chooseToRight = dp(idx + 1, sum + rods[idx]); // 选到右侧
        memo[idx][sum] = Math.max(nonChoose, Math.max(chooseToLeft, chooseToRight));
        return memo[idx][sum];
    }

    public int tallestBillboard(int[] rods) {
        this.rods = rods;
        this.len = rods.length;
        memo = new Integer[len][10001];
        return dp(0, 5000);
    }

}
