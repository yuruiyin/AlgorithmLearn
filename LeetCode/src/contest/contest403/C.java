package contest.contest403;

import java.util.Arrays;

public class C {

    private long[] memo;

    private int[] arr;

    private int len;

    private long rec(int idx) {
        if (idx == len) {
            return 0;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        long res1 = arr[idx] + rec(idx + 1);
        long res2 = Long.MIN_VALUE;
        if (idx < len - 1) {
            res2 = arr[idx] - arr[idx + 1] + rec(idx + 2);
        }

        return memo[idx] = Math.max(res1, res2);
    }

    public long maximumTotalCost(int[] nums) {
        this.len = nums.length;
        this.arr = nums;
        memo = new long[len];
        Arrays.fill(memo, -1);
        return rec(0);
    }

}
