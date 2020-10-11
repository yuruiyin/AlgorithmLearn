package fall_2020;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/12
 */
public class D {

    private static final int MOD = 1000000007;
    private long inc;
    private long dec;
    private int[] jumps;
    private int[] costs;
    private int len;
    private Map<Long, Long> memoMap;

    private long dp(long cur) {
        if (cur == 0) {
            return 0;
        }

        if (cur == 1) {
            return inc;
        }

        if (memoMap.containsKey(cur)) {
            return memoMap.get(cur);
        }

        long min = cur * inc;
        for (int i = 0; i < len; i++) {
            int jump = jumps[i];
            int cost = costs[i];

            if (cur % jump == 0) {
                min = Math.min(min, dp(cur / jump) + cost);
            } else {
                min = Math.min(min, dp( cur / jump) + cost + (cur % jump) * inc);
                min = Math.min(min, dp(cur / jump + 1) + cost + (jump - cur % jump) * dec);
            }
        }

        memoMap.put(cur, min);
        return memoMap.get(cur);
    }

    public int busRapidTransit(int target, int inc, int dec, int[] jumps, int[] costs) {
        this.inc = inc;
        this.dec = dec;
        this.jumps = jumps;
        this.costs = costs;
        this.len = costs.length;

        memoMap = new HashMap<>();
        return (int) (dp(target) % MOD);
    }

}
