package doubleContest.round24;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class D {

    private static final int MOD = 1000000007;

    private int k;
    private String s;
    private long[] memo;
    private int len;

    private long dp(int idx) {
        if (idx == len) {
            // TODO
            return 1;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        if (s.charAt(idx) == '0') {
            return 0;
        }

        long ans = 0;
        for (int i = idx; i < len; i++) {
            String numStr = s.substring(idx, i + 1);
            long num = Long.parseLong(numStr);
            if (num > k) {
                break;
            }

            ans = (ans + dp(i + 1)) % MOD;
        }

        memo[idx] = ans;
        return memo[idx];
    }

    public int numberOfArrays(String s, int k) {
        this.s = s;
        this.k = k;
        this.len = s.length();

        memo = new long[len + 1];
        Arrays.fill(memo, -1);
        return (int) (dp(0) % MOD);
    }

}
