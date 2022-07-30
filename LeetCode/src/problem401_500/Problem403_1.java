package problem401_500;

import java.util.HashMap;
import java.util.Map;

public class Problem403_1 {

    private int[] stones;
    private int len;

    private boolean[][] memo;

    private Map<Integer, Integer> indexMap;

    private boolean rec(int k, int curIdx) {
        if (curIdx == len - 1) {
            return true;
        }

        if (memo[k][curIdx]) {
            return false;
        }

        // 下一次可跳k - 1, k, k + 1
        for (int step = Math.max(1, k - 1); step <= k + 1; step++) {
            int next = step + stones[curIdx];
            int nextIdx = indexMap.getOrDefault(next, -1);
            if (nextIdx == -1) {
                continue;
            }
            if (rec(step, nextIdx)) {
                return true;
            }
        }

        memo[k][curIdx] = true;
        return false;
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
        memo = new boolean[len][len];
        calcIndexMap();
        return rec(1, 1);
    }

}
