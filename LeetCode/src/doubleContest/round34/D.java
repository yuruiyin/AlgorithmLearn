package doubleContest.round34;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/5
 */
public class D {

    private static final int MOD = (int) (1e9 + 7);

    private int[] arr;
    private int len;
    private int end;
    private long[][] memo;

    private long dp(int cur, int fuel) {
        if (fuel < 0) {
            return 0;
        }

        if (memo[cur][fuel] != -1) {
            return memo[cur][fuel];
        }

        int offset = cur == end ? 1 : 0;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            if (i == cur) {
                continue;
            }
            sum = (sum + dp(i, fuel - Math.abs(arr[i] - arr[cur]))) % MOD;
        }

        sum = (sum + offset) % MOD;
        memo[cur][fuel] = sum;
        return sum;
    }

    public int countRoutes(int[] locations, int start, int end, int fuel) {
        this.arr = locations;
        this.len = arr.length;
        this.end = end;

        memo = new long[len + 1][fuel + 1];

        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }

        return (int) (dp(start, fuel) % MOD);
    }

}
