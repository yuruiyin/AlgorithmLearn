package contest.contest085;

import java.util.Arrays;

public class Problem03 {

    private int w;
    private double[] memo;

    private double dfs(int n, int k) {
        if (k <= 0) {
            return 1.0;
        }

        if (n <= 0) {
            return 0;
        }

        if (memo[k] != -1) {
            return memo[k];
        }

        double ans = 0;
        int max = Math.min(n, w);
        for (int i = 1; i <= max; i++) {
            if (k - i <= 0) {
                ans += max - i + 1.0;
                break;
            }
            ans += dfs(n-i, k-i);
        }

        ans /= w;
        memo[k] = ans;
        return ans;
    }

    public double new21Game(int n, int k, int w) {
        this.w = w;
        memo = new double[k+1];
        Arrays.fill(memo, -1);
        return dfs(n, k);
    }

}
