import java.util.Arrays;

/**
 * LintCode1687
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode1687 {

    private long[] memo;
    private int n;

    private long dp(int idx) {
        if (idx > n) {
            return 0;
        }

        if (idx == n) {
            return 1;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        // 横放和竖放,横放一下要放两个
        long res = dp(idx + 1) + dp(idx + 2);
        memo[idx] = res;
        return res;
    }

    public long getTotalSchemes(int n) {
        // Write your code here.
        this.n = n;
        memo = new long[n];
        Arrays.fill(memo, -1);
        return dp(0);
    }

}
