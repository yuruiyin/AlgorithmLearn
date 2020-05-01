package problem301_400;

/**
 * Problem375
 *
 * @author: yry
 * @date: 2020/4/13
 */
public class Problem375 {

    private Integer[][] memo;

    // 区间dp
    private int dp(int l, int r) {
        int count = r - l + 1;
        if (count <= 1) {
            return 0;
        }

        if (count == 2) {
            return l;
        }

        if (count == 3) {
            return l + 1;
        }

        if (memo[l][r] != null) {
            return memo[l][r];
        }

        // 先单独处理两边的
        int chooseLeft = l + dp(l + 1, r);
        int chooseRight = dp(l, r - 1) + r;
        int min = Math.min(chooseLeft, chooseRight);
        for (int i = l + 1; i <= r - 1; i++) {
            int res = i + Math.max(dp(l, i - 1), dp(i + 1, r));
            min = Math.min(min, res);
        }

        memo[l][r] = min;
        return min;
    }

    public int getMoneyAmount(int n) {
        memo = new Integer[n+1][n+1];
        return dp(1, n);
    }

    public static void main(String[] args) {
        System.out.println(new Problem375().getMoneyAmount(10));
    }

}
