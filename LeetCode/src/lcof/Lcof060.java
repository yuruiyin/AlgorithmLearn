package lcof;

public class Lcof060 {

    private Integer[][] memo;

    private int dp(int n, int s) {
        if (s < n || s > 6 * n) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (memo[n][s] != null) {
            return memo[n][s];
        }

        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count += dp(n-1, s - i);
        }

        memo[n][s] = count;
        return count;
    }

    public double[] twoSum(int n) {
        double[] ans = new double[5 * n + 1];
        int index = 0;
        memo = new Integer[n + 1][6 * n + 1];
        for (int s = n; s <= 6 * n; s++) {
            ans[index++] = dp(n, s) * 1.0 / Math.pow(6, n);
        }

        return ans;
    }

}
