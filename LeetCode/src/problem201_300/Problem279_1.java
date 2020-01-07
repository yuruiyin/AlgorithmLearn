package problem201_300;

import java.util.Arrays;

public class Problem279_1 {

    private int[] memo;

    private int backTrack(int n) {
        if (n == 0) {
            return 0;
        }

        if (memo[n] != -2) {
            return memo[n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int res = backTrack(n - i * i);
            if (res == -1) {
                continue;
            }

            min = Math.min(min,res);
        }

        memo[n] = min == Integer.MAX_VALUE ? -1 : min + 1;
        return memo[n];
    }

    public int numSquares(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -2);
        return backTrack(n);
    }

}
