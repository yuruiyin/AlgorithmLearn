package contest.contest413;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {

    private int[][] grid;

    private int m;
    private int n;

    private Map<String, Integer> memoMap;

    private int rec(long high, long low, int rowVisited) {
        if (rowVisited + 1 == (1 << m)) {
            // 每行全部选中了
            return 0;
        }

        String key = high + "," + low + "," + rowVisited;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int ansMax = 0;
        for (int i = 0; i < m; i++) {
            if ((rowVisited & (1 << i)) != 0) {
                continue;
            }

            rowVisited = rowVisited | (1 << i);
            for (int j = 0; j < n; j++) {
                int value = grid[i][j];
                long newHigh = high;
                long newLow = low;
                if (value > 64) {
                    if ((high & (1L << (value - 65))) != 0) {
                        continue;
                    }
                    newHigh = high | (1L << (value - 65));
                } else {
                    if ((low & (1L << (value - 1))) != 0) {
                        continue;
                    }
                    newLow = low | (1L << (value - 1));
                }
                ansMax = Math.max(ansMax, rec(newHigh, newLow, rowVisited) + value);
            }

            rowVisited = rowVisited ^ (1 << i);
        }

        memoMap.put(key, ansMax);
        return ansMax;
    }

    public int maxScore(List<List<Integer>> list) {
        this.m = list.size();
        this.n = list.get(0).size();
        this.grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = list.get(i).get(j);
            }
        }

        memoMap = new HashMap<>();
        return rec(0, 0, 0);
    }

}
