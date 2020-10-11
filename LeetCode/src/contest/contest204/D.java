package contest.contest204;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/30
 */
public class D {

    // 使用乘法逆元求组合数，当mod是素数且较大时
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

            if (m > n - m) {
                m = n - m;
            }

            return frac[n] * inv[m] % mod * inv[n - m] % mod;
        }

    }

    private static final int MOD = 1000000007;
    private int[] arr;
    private CombinationInv combinationInv;

    private long rec(int l, int r) {
        int n = r - l + 1;
        if (n <= 2) {
            return 1;
        }

        int root = arr[l];
        int pivot = -1;

        for (int i = l + 1; i <= r; i++) {
            if (i < r && arr[i] < root && arr[i + 1] > root || i < r && arr[i] > root && arr[i + 1] < root) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            return rec(l + 1, r);
        }

        return (((combinationInv.c(n - 1, pivot - l) * rec(l + 1, pivot)) % MOD) * rec(pivot + 1, r)) % MOD;
    }

    public int numOfWays(int[] nums) {
        this.arr = nums;
        int n = nums.length;
        combinationInv = new CombinationInv(MOD, n);
        long ans = rec(0, n - 1);
        ans = (ans + MOD - 1) % MOD;
        return (int) ans;
    }

}
