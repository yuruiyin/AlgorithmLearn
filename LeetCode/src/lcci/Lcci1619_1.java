package lcci;

import java.util.*;

public class Lcci1619_1 {

    private int rowCount;
    private int colCount;

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= rowCount || c < 0 || c >= colCount || grid[r][c] != 0) {
            return 0;
        }

        grid[r][c] = -1;
        return 1 + dfs(grid, r - 1, c - 1) +
                dfs(grid, r - 1, c) +
                dfs(grid, r - 1, c + 1) +
                dfs(grid, r, c - 1) +
                dfs(grid, r, c + 1) +
                dfs(grid, r + 1, c - 1) +
                dfs(grid, r + 1, c) +
                dfs(grid, r + 1, c + 1);
    }
    public int[] pondSizes(int[][] land) {
        this.rowCount = land.length;
        this.colCount = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (land[i][j] != 0) {
                    continue;
                }
                list.add(dfs(land, i, j));
            }
        }
        int size = list.size();
        int[] ansArr = new int[size];
        for (int i = 0; i < size; i++) {
            ansArr[i] = list.get(i);
        }
        Arrays.sort(ansArr);
        return ansArr;
    }

}
