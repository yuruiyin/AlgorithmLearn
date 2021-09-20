package contest.contest254;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/15
 */
public class C {

    private static final int MOD = (int) 1e9 + 7;

    // 快速幂
    public int pow(long x, long n, int mod) {
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

    public int minNonZeroProduct(int p) {
        long x = (1L << p) - 2;
        long n = x >>> 1;
        return (int) (((long)pow(x, n, MOD) * (((1L << p) - 1) % MOD)) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new C().minNonZeroProduct(1));
        System.out.println(new C().minNonZeroProduct(2));
        System.out.println(new C().minNonZeroProduct(3));
        System.out.println(new C().minNonZeroProduct(4));
        System.out.println(new C().minNonZeroProduct(5));
    }

}
