package contest.contest098;

import java.util.Arrays;

public class Problem891 {

    private static final int MOD = (int) (1e9 + 7);

    public int sumSubseqWidths(int[] arr) {
        int len = arr.length;
        long[] sumArr = new long[len];
        long[] powArr = new long[len];
        Arrays.sort(arr);

        powArr[0] = 1;
        for (int i = 1; i < len; i++) {
            powArr[i] = (powArr[i-1] << 1) % MOD;
        }

        sumArr[0] = 1;
        for (int i = 1; i < len; i++) {
            sumArr[i] = (sumArr[i-1] + powArr[i]) % MOD;
        }

        long[] dp = new long[len];
        dp[0] = 0;
        long ans = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = (2 * dp[i-1] + sumArr[i-1] * (arr[i] - arr[i-1])) % MOD;
            ans = (ans + dp[i]) % MOD;
        }

        return (int) (ans % MOD);
    }

}
