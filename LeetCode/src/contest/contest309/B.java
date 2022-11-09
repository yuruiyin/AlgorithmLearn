package contest.contest309;

import java.util.HashMap;
import java.util.Map;

public class B {

    private static final long MOD = (int) (1e9+7);

    private Map<Integer, Integer> memoMap;

    private int rec(int s, int e, int k) {
        if (k == 0) {
            return s == e ? 1 : 0;
        }

        if (Math.abs(s - e) > k) {
            return 0;
        }

        int key = s * 1000 + k;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        long ans = 0;
        ans = (ans + rec(s - 1, e, k - 1)) % MOD;
        ans = (ans + rec(s + 1, e, k - 1)) % MOD;
        memoMap.put(key, (int) (ans % MOD));
        return (int) (ans % MOD);
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        int dis = Math.abs(startPos - endPos);
        if ((k - dis) % 2 == 1 || dis > k) {
            return 0;
        }

        if (dis == k) {
            return 1;
        }

        memoMap = new HashMap<>();
        return (int) (rec(startPos, endPos, k) % MOD);
    }

}
