package utils;

// 求大数组合数 C(n,m)，如求C(4, 2), mod是素数且较小（10^5）
public class CombinationLucas {

    private long mod;

    public CombinationLucas(long mod) {
        this.mod = mod;
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
        return res;
    }

    public long c(long n, long m) {
        if (n < m) {
            return 0;
        }

        // c(n,m) = n! / m! /(n-m)!
        long res = 1;
        for (int i = 1; i <= m; i++) {
            long a = (n + i - m) % mod;
            long b = i % mod;
            res = res * (a * pow(b, mod - 2) % mod) % mod;
        }

        return res;
    }

    long lucas(long n, long m) {
        if (m == 0) {
            return 1;
        }
        return c(n % mod, m % mod) * lucas(n / mod, m/ mod) % mod;
    }

}
