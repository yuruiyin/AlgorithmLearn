package problem1001_1100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1001 {

    private static final long MAX_NUM = 1000000000L;

    private Map<Integer, Integer> rowMap = new HashMap<>();
    private Map<Integer, Integer> columnMap = new HashMap<>();
    private Map<Integer, Integer> sumMap = new HashMap<>();
    private Map<Integer, Integer> rowColDiffMap = new HashMap<>();

    // 标记某些位置是否有灯，1000000000L * row + col
    private Set<Long> lampSet = new HashSet<>();

    private void setFlagMap(Map<Integer, Integer> flagMap, int key) {
        if (flagMap.containsKey(key)) {
            flagMap.put(key, flagMap.get(key) + 1);
        } else {
            flagMap.put(key, 1);
        }
    }

    private void minusFlagMapCount(Map<Integer, Integer> flagMap, int key) {
        flagMap.put(key, flagMap.get(key) - 1);
    }

    private void closeNeighborLamp(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow < 0 || newCol < 0) {
                    continue;
                }

                long lamp = MAX_NUM * newRow + newCol;
                if (lampSet.contains(lamp)) {
                    lampSet.remove(lamp);
                    minusFlagMapCount(rowMap, newRow);
                    minusFlagMapCount(columnMap, newCol);
                    minusFlagMapCount(sumMap, newRow + newCol);
                    minusFlagMapCount(rowColDiffMap, newRow - newCol);
                }
            }
        }
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int queryCount = queries.length;
        if (queryCount == 0) {
            return new int[]{};
        }

        for (int[] lamp : lamps) {
            int row = lamp[0];
            int col = lamp[1];
            int sum = row + col;
            int rowColDiff = row - col;
            setFlagMap(rowMap, row);
            setFlagMap(columnMap, col);
            setFlagMap(sumMap, sum);
            setFlagMap(rowColDiffMap, rowColDiff);
            lampSet.add(MAX_NUM * row + col);
        }

        int[] ansArr = new int[queryCount];
        int count = 0;

        for (int[] query : queries) {
            int row = query[0];
            int col = query[1];
            int sum = row + col;
            int rowColDiff = row - col;

            if (rowMap.containsKey(row) && rowMap.get(row) >= 1 ||
                    columnMap.containsKey(col) && columnMap.get(col) >= 1 ||
                    sumMap.containsKey(sum) && sumMap.get(sum) >= 1 ||
                    rowColDiffMap.containsKey(rowColDiff) && rowColDiffMap.get(rowColDiff) >= 1
            ) {
                ansArr[count++] = 1;
            } else {
                ansArr[count++] = 0;
            }

            // 关掉当前询问位置和周围相邻8个位置的灯
            closeNeighborLamp(row ,col);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[][] lamps = new int[][] {
                {0,0},
                {4,4}
        };

        int[][] queries = new int[][] {
                {1,1},
                {1,0}
        };

        int[] ansArr = new Problem1001().gridIllumination(5, lamps, queries);

        for (int num: ansArr) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

}
