package contest.contest413;

import java.util.*;

public class C_1 {

    private int[][] grid;

    private int m;
    private int n;

    private Map<String, Integer> memoMap;

    private int[][] bottomCountArr;

    private int rec(long high, long low, int row) {
        if (row == m) {
            // 选到最后一行了
            return 0;
        }

        String key = high + "," + low + "," + row;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        // 当前行选或不选
        int nonChooseRes = rec(high, low, row + 1);

        int chooseRes = 0;
        for (int j = 0; j < n; j++) {
            int value = grid[row][j];
            if (j > 0 && value == grid[row][j - 1]) {
                continue;
            }
            long newHigh = high;
            long newLow = low;
            if (value > 64) {
                long flag = 1L << (value - 65);
                if ((high & flag) != 0) {
                    continue;
                }
                newHigh = high | flag;
            } else {
                long flag = 1L << (value - 1);
                if ((low & flag) != 0) {
                    continue;
                }
                newLow = low | flag;
            }

            chooseRes = Math.max(chooseRes, rec(newHigh, newLow, row + 1) + value);

            // 如果这个值在当前及其以下行只有1个，则break
            if (bottomCountArr[row][value] == 1) {
                break;
            }
        }

        int max = Math.max(nonChooseRes, chooseRes);
        memoMap.put(key, max);
        return max;
    }

    private void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    public int maxScore(List<List<Integer>> list) {
        this.m = list.size();
        this.n = list.get(0).size();
        this.grid = new int[m][n];
        int maxValue = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = list.get(i).get(j);
                maxValue = Math.max(maxValue, grid[i][j]);
            }
            // 排序当前行，从大到小
            sortDesc(grid[i]);
        }

        bottomCountArr = new int[m][maxValue + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int value = grid[i][j];
                if (i == m - 1) {
                    bottomCountArr[i][value] = 1;
                } else {
                    for (int k = 1; k <= maxValue; k++) {
                        if (k == value) {
                            bottomCountArr[i][k] = bottomCountArr[i + 1][k] + 1;
                        } else {
                            bottomCountArr[i][k] = Math.max(bottomCountArr[i][k], bottomCountArr[i + 1][k]);
                        }
                    }
                }
            }
        }

        memoMap = new HashMap<>();
        return rec(0, 0, 0);
    }

    private static List<List<Integer>> generateGrid() {
        List<List<Integer>> list = new ArrayList<>();
        int n = 10;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                list.get(i).add(i * n + j);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new C_1().maxScore(generateGrid()));
    }

}
