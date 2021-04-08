package contest.contest234;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/28
 */
public class D {

    private static final int MOD = 1000000007;

    // 快速幂
    public static long pow(long x, long n, int mod) {
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

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 3) {
            return primeFactors;
        }

        long ans = 0;
        if (primeFactors % 3 == 0) {
            ans = pow(3, primeFactors / 3, MOD);
        } else {
            int count3 = primeFactors - 2 * (primeFactors / 3 + 1);
            int count2 = (primeFactors / 3 + 1) - count3;
            ans = (pow(2, count2, MOD) * pow(3, count3, MOD)) % MOD;
        }

        return (int) ans;
    }
}
