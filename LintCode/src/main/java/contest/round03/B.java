package contest.round03;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class B {

    private static final int MOD = 1000000007;

    private int[] arr;
    private int len;
    private long[][] memo;

    private long dp(int level, int idx) {
        int trueIdx = len - 1 - idx;
        if (trueIdx >= len - 1) {
            return 1;
        }

        if (arr[trueIdx] == 1) {
            return 0;
        }

        if (memo[level][trueIdx] != -1) {
            return memo[level][trueIdx];
        }

        long res;
        if (level == 0) {
            res = dp(1, idx - 1) + dp(1, idx - 3) + dp(1, idx - 4);
        } else {
            res = dp(0, idx - 1) + dp(0, idx - 2) + dp(0, idx - 4);
        }

        res %= MOD;
        memo[level][trueIdx] = res;
        return res;
    }

    public int ratJump(int[] arr) {
        this.arr = arr;
        this.len = arr.length;

        memo = new long[2][len + 1];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(memo[i], -1);
        }

//        long res1 = dp(1, len - 1);
//        long res2 = dp(1, len - 3);
//        long res3 = dp(1, len - 4);
//        return (int) ((res1 + res2 + res3) % MOD);

        return (int) (dp(1, len - 1) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new B().ratJump(new int[]{0, 0, 0}));
        System.out.println(new B().ratJump(new int[]{0, 0, 1, 0}));

    }

}
