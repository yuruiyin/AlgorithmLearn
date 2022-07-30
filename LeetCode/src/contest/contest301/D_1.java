package contest.contest301;

import java.util.HashMap;
import java.util.Map;

public class D_1 {

    private static final int MOD = (int) (1e9 + 7);

    private int maxValue;

    private int n;

    private Map<Integer, Long> memoMap;

    private long rec(int idx, int from) {
        if (idx == n - 1) {
            return 1;
        }

        if (from * 2 > maxValue) {
            return 1;
        }

        int key = idx * (maxValue + 1) + from;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        long res = 0;
        for (int next = from; next <= maxValue; next += from) {
            res = (res + rec(idx + 1, next)) % MOD;
        }

        memoMap.put(key, res);
        return res;

    }

    public int idealArrays(int n, int maxValue) {
        this.maxValue = maxValue;
        this.n = n;
        memoMap = new HashMap<>();
        long ans = 0;
        for (int i = 1; i <= maxValue; i++) {
            ans = (ans + rec(0, i)) % MOD;
        }
        return (int) (ans % MOD);
    }

}
