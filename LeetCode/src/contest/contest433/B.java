package contest.contest433;

import java.util.Arrays;

public class B {

    static class CombinationInv {

        private long mod;
        private long[] frac;
        private long[] inv;

        public CombinationInv(long mod, int MAXN) {
            this.mod = mod;
            frac = new long[MAXN + 10];
            inv = new long[MAXN + 10];
            frac[0] = inv[0] = 1;
            init(MAXN);
        }

        private void init(int m) {
            for (int i = 1; i <= m; i++) {
                frac[i] = frac[i - 1] * i % mod;
                inv[i] = pow(frac[i], mod - 2);
            }
        }

        // 快速pow 二分
        private long pow(long x, long n) {
            long res = 1;
            x %= mod;
            while (n > 0) {
                if ((n & 1) == 1) {
                    res = (res * x) % mod;
                }

                x = (x * x) % mod;
                n >>= 1;
            }
            return res % mod;
        }

        public long c(int n, int m) {
            if (m < 0 || n < m) {
                return 0;
            }

            if (n == m) {
                return 1;
            }

            if (m > n - m) {
                m = n - m;
            }

            return frac[n] * inv[m] % mod * inv[n - m] % mod;
        }

    }

    private static final int MOD = (int) (1e9 + 7);

    private void calcFactorial(int[] factorials) {
        factorials[0] = 0;
        factorials[1] = 1;
        for (int i = 2; i <= 100; i++) {
            factorials[i] = (factorials[i - 1] * i) % MOD;
        }
    }

    private static final CombinationInv combinationInv = new CombinationInv(MOD, 100001);

    public int minMaxSums(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        long sum = 0;
//        int[] factorials = new int[101];
//        calcFactorial(factorials);

        for (int i = 0; i < len; i++) {
            int rightCount = Math.min(k, len - i);
            long count1 = 0;
            for (int j = rightCount - 1; j >= 0; j--) {
                count1 = (count1 + combinationInv.c(len - i - 1, j)) % MOD;
            }
//            long count1 = (combinationInv.c(len - i - 1, rightCount - 1) * combinationInv.pow(2, rightCount - 1)) % MOD;
            sum = (sum + (count1 * nums[i]) % MOD) % MOD;
            int leftCount = Math.min(i + 1, k);
            long count2 = 0;
            for (int j = leftCount - 1; j >= 0; j--) {
                count2 = (count2 + combinationInv.c(i, j)) % MOD;
            }
//            long count2 = (combinationInv.c(i, leftCount - 1) * combinationInv.pow(2, leftCount - 1)) % MOD;
            sum = (sum + (count2 * nums[i]) % MOD) % MOD;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
//        System.out.println(new B().minMaxSums(new int[]{0, 0, 0, 2}, 3));
//        System.out.println(new B().minMaxSums(new int[]{0, 1, 1}, 3));
        System.out.println(new B().minMaxSums(new int[]{1, 2, 3}, 2));
    }
}
