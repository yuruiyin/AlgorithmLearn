package problem401_500;

import java.util.HashMap;
import java.util.Map;

public class Problem403 {

    private int[] stones;
    private int len;

    private Map<Integer, Boolean> memoMap;

    private Map<Integer, Integer> indexMap;

    private boolean rec(int k, int curIdx) {
        if (curIdx == len - 1) {
            return true;
        }

        int key = k * 2000 + curIdx;

        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        // 下一次可跳k - 1, k, k + 1
        boolean isOk = false;
        for (int step = Math.max(1, k - 1); step <= k + 1; step++) {
            int next = step + stones[curIdx];
            int nextIdx = indexMap.getOrDefault(next, -1);
            if (nextIdx == -1) {
                continue;
            }
            if (rec(step, nextIdx)) {
                isOk = true;
                break;
            }
        }

        memoMap.put(key, isOk);
        return isOk;
    }

    private void calcIndexMap() {
        indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(stones[i], i);
        }
    }

    public boolean canCross(int[] stones) {
        if (stones[1] != stones[0] + 1) {
            return false;
        }

        this.stones = stones;
        this.len = stones.length;
        memoMap = new HashMap<>();
        calcIndexMap();
        return rec(1, 1);
    }

}
