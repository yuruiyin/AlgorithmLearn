package contest.contest330;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    private long pow(long x, long n, long mod) {
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

    public int monkeyMove(int n) {
        return (int) ((pow(2, n, MOD) - 2L + MOD) % MOD);
    }

}
