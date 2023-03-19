package contest.contest335;

import java.util.Arrays;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    private long[][] memo;

    private int[][] types;

    private int len;

    private long dp(int curIdx, int target) {
        if (curIdx == len) {
            if (target == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        if (target == 0) {
            return 1;
        }

        if (memo[curIdx][target] != -1) {
            return memo[curIdx][target];
        }

        // 不做
        long ans = 0;
//        long noRes = dp(curIdx + 1, target);
//        if (noRes != -1) {
//            ans += noRes;
//        }

        int[] type = types[curIdx];
        int count = type[0];
        int score = 0;
        for (int i = 0; i <= count; i++) {
            score = i * type[1];
            if (score > target) {
                break;
            }
            long res = dp(curIdx + 1, target - score);
            if (res != -1) {
                ans += res;
            }
        }

        return memo[curIdx][target] = ans % MOD;
    }

    public int waysToReachTarget(int target, int[][] types) {
        this.types = types;
        this.len = types.length;
        memo = new long[len][target + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return (int) (dp(0, target) % MOD);
    }

}
