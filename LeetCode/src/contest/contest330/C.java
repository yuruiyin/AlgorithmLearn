package contest.contest330;

import java.util.HashMap;
import java.util.Map;

public class C {

    private int[] weights;

    private int len;

    private long[] sufSumArr;

    private Map<Long, Long> memoMap;

    private long recMax(int curIdx, int k) {
        if (curIdx == len) {
            return k == 0 ? 0 : -1;
        }

        if (k == 1) {
            return weights[curIdx] + weights[len - 1];
        }

        if (len - curIdx < k) {
            return -1;
        }

        if (len - curIdx == k) {
            return sufSumArr[curIdx] * 2;
        }

        long key = curIdx * 100001L + k;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        long ansMax = 0;
        for (int i = curIdx; i < len; i++) {
            long next = recMax(i + 1, k - 1);
            if (next == -1) {
                continue;
            }
            ansMax = Math.max(ansMax, weights[curIdx] + weights[i] + next);
        }

        memoMap.put(key, ansMax);
        return ansMax;
    }

    private long recMin(int curIdx, int k) {
        if (curIdx == len) {
            return k == 0 ? 0 : -1;
        }

        if (k == 1) {
            return weights[curIdx] + weights[len - 1];
        }

        if (len - curIdx < k) {
            return -1;
        }

        if (len - curIdx == k) {
            return sufSumArr[curIdx] * 2;
        }

        long key = curIdx * 100001L + k;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        long ansMin = Long.MAX_VALUE;
        for (int i = curIdx; i < len; i++) {
            long next = recMin(i + 1, k - 1);
            if (next == -1) {
                continue;
            }
            ansMin = Math.min(ansMin, weights[curIdx] + weights[i] + next);
        }

        memoMap.put(key, ansMin);
        return ansMin;
    }

    private void calcSufSumArr() {
        sufSumArr = new long[len];
        sufSumArr[len - 1] = weights[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] = sufSumArr[i + 1] + weights[i];
        }
    }

    public long putMarbles(int[] weights, int k) {
        // DP
        this.weights = weights;
        this.len = weights.length;
        calcSufSumArr();
        memoMap = new HashMap<>();
        long ansMax = recMax(0, k);
        memoMap = new HashMap<>();
        long ansMin = recMin(0, k);
        return ansMax - ansMin;
    }

}
