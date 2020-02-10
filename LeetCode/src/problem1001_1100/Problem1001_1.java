package problem1001_1100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1001_1 {

    private static final long MAX_NUM = 1000000000L;

    private Map<Integer, Integer> rowMap = new HashMap<>();
    private Map<Integer, Integer> colMap = new HashMap<>();
    private Map<Integer, Integer> sumMap = new HashMap<>();
    private Map<Integer, Integer> diffMap = new HashMap<>();
    private Set<Long> lampSet = new HashSet<>();
    private int N;

    private void closeNearbyLamps(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int curRow = row + i;
                int curCol = col + j;
                if (curRow < 0 || curRow >= N || curCol < 0 || curCol >= N) {
                    continue;
                }

                long key = curRow * MAX_NUM + curCol;

                if (!lampSet.contains(key)) {
                    continue;
                }

                int sum = curRow + curCol;
                int diff = curRow - curCol;
                rowMap.put(curRow, rowMap.getOrDefault(curRow, 0) - 1);
                colMap.put(curCol, colMap.getOrDefault(curCol, 0) - 1);
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) - 1);
                diffMap.put(diff, diffMap.getOrDefault(diff, 0) - 1);
                lampSet.remove(key);
            }
        }
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        this.N = N;
        for (int[] lamp : lamps) {
            int row = lamp[0];
            int col = lamp[1];
            int sum = row + col;
            int diff = row - col;
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
            colMap.put(col, colMap.getOrDefault(col, 0) + 1);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            diffMap.put(diff, diffMap.getOrDefault(diff, 0) + 1);
            lampSet.add(row * MAX_NUM + col);
        }

        int queryLen = queries.length;
        int[] ans = new int[queryLen];
        for (int i = 0; i < queryLen; i++) {
            int[] query = queries[i];
            int row = query[0];
            int col = query[1];
            int sum = row + col;
            int diff = row - col;

            if (rowMap.getOrDefault(row, 0) >= 1 || colMap.getOrDefault(col, 0) >= 1 ||
                sumMap.getOrDefault(sum, 0) >= 1 || diffMap.getOrDefault(diff, 0) >= 1) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }

            // 关闭当前位置及其相邻8个方向上的灯
            closeNearbyLamps(row, col);
        }

        return ans;
    }

}
