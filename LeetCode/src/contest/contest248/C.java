package contest.contest248;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/4
 */
public class C {

    private static final int MOD = (int) (1e9 + 7);

    // 快速幂
    private long pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }

            x = x * x % mod;
            n >>>= 1;
        }
        return res % mod;
    }

    public int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }
        long evenCount = n / 2 + n % 2;
        long oddCount = n / 2;
        return (int) ((pow(5, evenCount, MOD) * pow(4, oddCount, MOD)) % MOD);
    }

}
