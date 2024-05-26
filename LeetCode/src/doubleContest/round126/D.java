package doubleContest.round126;

import java.util.Arrays;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    private Integer[][][] memo;

    private int[] sufSumArr;

    private int[] nums;

    private int len;

    private int dp(int idx, int count, int sum) {
        if (count == 0) {
            return sum == 0 ? 1 : 0;
        }

        if (sum == 0) {
            return 0;
        }

        if (idx == len) {
            return 0;
        }

        if (sufSumArr[idx] < sum || nums[idx] > sum || len - idx < count) {
            return 0;
        }

        if (memo[idx][count][sum] != null) {
            return memo[idx][count][sum];
        }

        int chooseRes = dp(idx + 1, count - 1, sum - nums[idx]);
        int nonChooseRes = dp(idx + 1, count, sum);
        return memo[idx][count][sum] = (chooseRes + nonChooseRes) % MOD;
    }


    private void calcPreSumArr() {
        sufSumArr = new int[len];
        sufSumArr[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] += sufSumArr[i + 1] + nums[i];
        }
    }

    // 快速幂
    public static int pow(long x, long n, int mod) {
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

    public int sumOfPower(int[] nums, int k) {
        // 选1 ~ 100个数使得和为k
        Arrays.sort(nums);
        this.nums = nums;
        this.len = nums.length;
        calcPreSumArr();
        long ans = 0;
        memo = new Integer[101][101][101];
        for (int count = 1; count <= k; count++) {
            long res = dp(0, count, k);
            long leftCount = len - count;
            int cur = (int) ((res * pow(2, leftCount, MOD)) % MOD);
            ans = (ans + cur) % MOD;
        }

        return (int) ans;
    }

}
