package doubleContest.round133;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class D {

    private static final int MOD = 1000000007;

    private Map<Integer, Integer> memoMap;

    private int[][] requirements;
    private int reqLen;

    private int n;

    private int rec(int pos, int invs, int reqIdx) {
        if (reqIdx < reqLen && pos > requirements[reqIdx][0]) {
            return 0;
        }

        if (pos == n) {
            return reqIdx == reqLen ? 1 : 0;
        }

        int key = pos * 400 * 300 + invs * 300 + reqIdx;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int res = 0;
        for (int i = 0; i <= pos; i++) {
            int newInvs = invs + (pos - i);
            if (reqIdx < reqLen && pos == requirements[reqIdx][0] && newInvs != requirements[reqIdx][1]) {
                continue;
            }
            res = (res + rec(pos + 1, newInvs, reqIdx + (pos == requirements[reqIdx][0] ? 1 : 0))) % MOD;
        }

        memoMap.put(key, res);
        return res;
    }

    public int numberOfPermutations(int n, int[][] requirements) {
        this.n = n;
        memoMap = new HashMap<>();
        this.requirements = requirements;
        this.reqLen = this.requirements.length;
        // 基于end从小到大排序
        Arrays.sort(requirements, Comparator.comparingInt(o -> o[0]));
        return rec(0, 0, 0);
    }


}
