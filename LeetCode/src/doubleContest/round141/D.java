package doubleContest.round141;

public class D {

    // 使用乘法逆元求组合数，当mod是素数且较大时
    public class CombinationInv {

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
        public long pow(long x, long n) {
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

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfWays(int n, int x, int y) {
        long ans = 0;
        CombinationInv combinationInv = new CombinationInv(MOD, 1000);
        long factor = 1;
        for (int k = 1; k <= Math.min(x, n); k++) {
            // k 个节目有表演者
            long pow = combinationInv.pow(y, k);
            long comb1 = combinationInv.c(x, k);
            long comb2 = combinationInv.c(n, k);
            factor = (factor * k) % MOD;
            ans = (ans + ((pow * comb1) % MOD) * factor) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().numberOfWays(3, 3, 4));
        System.out.println(new D().numberOfWays(1, 2, 3));
    }

}
