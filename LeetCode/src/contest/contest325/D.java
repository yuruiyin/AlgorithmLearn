package contest.contest325;

import java.util.Arrays;

public class D {

    private static final int MOD = (int) (1e9+7);

    private int[][] memo;

    private int len;

    private int k;

    private int[] nums;

    private int dp(int idx, int pre) {
        if (pre >= k) {
            return 0;
        }
        if (idx == len) {
            return 1;
        }

        if (memo[idx][pre] != -1) {
            return memo[idx][pre];
        }

        long chooseRes = dp(idx + 1, pre + nums[idx]);
        long nonChooseRes = dp(idx + 1, pre);
        return memo[idx][pre] = (int) ((chooseRes + nonChooseRes) % MOD);
    }

    // 快速幂
    private int pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }

            x = x * x % mod;
            n >>>= 1;
        }
        return (int) res % mod;
    }

    public int countPartitions(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < 2L * k) {
            return 0;
        }

        this.len = nums.length;
        this.k = k;
        this.nums = nums;
        memo = new int[len][k + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 小于k的分区数
        int lowerK = dp(0, 0);

        // 用全部的分区数 - 小于k的分区数 即答案
        int total = pow(2, len, MOD);

        System.out.println("hel");

        return (int) ((total + 2L * MOD - 2 * lowerK) % MOD);
    }

    public static void main(String[] args) {
//        System.out.println(new D().countPartitions(new int[]{1,2,3,4}, 4));

//        [96,40,22,98,9,97,45,22,79,57,95,62]
//        505
        System.out.println(new D().countPartitions(new int[]{96,40,22,98,9,97,45,22,79,57,95,62}, 505));
    }

}
