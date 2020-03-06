package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcci0812 {

    private int n;
    private List<List<String>> ansList;

    private List<String> getList(char[][] grid) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(String.valueOf(grid[i]));
        }

        return list;
    }

    private void backTrack(int row, char[][] grid, boolean[] colUsed, boolean[] sumUsed, boolean[] diffUsed) {
        if (row == n) {
            ansList.add(getList(grid));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colUsed[col] || sumUsed[row + col] || diffUsed[row - col + n]) {
                continue;
            }

            int sum = row + col;
            int diff = row - col + n;

            grid[row][col] = 'Q';
            colUsed[col] = true;
            sumUsed[sum] = true;
            diffUsed[diff] = true;
            backTrack(row + 1, grid, colUsed, sumUsed, diffUsed);
            colUsed[col] = false;
            sumUsed[sum] = false;
            diffUsed[diff] = false;
            grid[row][col] = '.';
        }
    }

    private void initGrid(char[][] grid) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        boolean[] colUsed = new boolean[n];
        boolean[] sumUsed = new boolean[2 * n];  // 撇
        boolean[] diffUsed = new boolean[2 * n]; // 捺
        char[][] grid = new char[n][n];
        initGrid(grid);
        ansList = new ArrayList<>();
        backTrack(0, grid, colUsed, sumUsed, diffUsed);
        return ansList;
    }

}
