package contest.contest398;

import java.util.HashMap;
import java.util.Map;

public class D {

    private int k;

    private Map<Long, Integer> memoMap;

    private int dp(long cur, long jump, int canBelow) {
        if (cur < 0) {
            return 0;
        }

        if (cur > k + 1) {
            return 0;
        }

        long key = cur * 60 + jump * 2 + canBelow;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int res = 0;
        if (cur == k) {
            res = 1;
        }

        if (canBelow == 1) {
            res += dp(cur - 1, jump, 0) + dp(cur + (1L << jump), jump + 1, 1);
        } else {
            res += dp(cur + (1L << jump), jump + 1, 1);
        }
        memoMap.put(key, res);
        return res;
    }

    public int waysToReachStair(int k) {
        if (k == 0) {
            return 2;
        }

//        if (k == 1) {
//            return 4;
//        }

        this.k = k;
        memoMap = new HashMap<>();
        return dp(1, 0, 1);
    }

}
