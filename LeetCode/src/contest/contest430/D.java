package contest.contest430;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    public int n;

    private int m;

    private Map<Long, Integer> memoMap;

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

    private int rec(int pre, int idx, int k) {
        if (idx == n) {
            if (k == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (k == 0) {
            return (int) (((long)(m - 1) * pow(m, Math.max(0, n - idx - 1), MOD)) % MOD);
        }
        long key = (long) (pre * 1e10 + idx * 1e5 + k);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int res = 0;
        if (pre == 0) {
            res = rec(1, idx + 1, k);
            res = (int) ((res + ((long) (m - 1) * rec(0, idx + 1, k))) % MOD);
        } else {
            res = rec(1, idx + 1, k - 1);
            res = (int) ((res + ((long) (m - 1) * rec(0, idx + 1, k))) % MOD);
        }

        memoMap.put(key, res);
        return res;
    }

    public int countGoodArrays(int n, int m, int k) {
        this.n = n;
        this.m = m;
        memoMap = new HashMap<>();
        int ans = rec(1, 1, k);
        ans = (int) ((ans + (long)(m - 1) * rec(0, 1, k)) % MOD);
        return (int) (((long)m * ans) % MOD);
    }

}
