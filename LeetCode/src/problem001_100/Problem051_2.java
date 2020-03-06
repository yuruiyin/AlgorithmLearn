package problem001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 位运算
public class Problem051_2 {

    private int n;
    private List<List<String>> ansList;

    private List<String> getList(char[][] grid) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new String(grid[i]));
        }

        return list;
    }

    /**
     * 回溯法求解n皇后问题，一行一行遍历
     * @param row  当前行
     * @param grid N皇后二维网格
     * @param colUsed 列是否使用标识
     * @param sumUsed 撇是否使用标识
     * @param diffUsed 捺是否使用标识
     */
    private void backTrack(int row, char[][] grid, int colUsed, int sumUsed, int diffUsed) {
        if (row == n) {
            ansList.add(getList(grid));
            return;
        }

        for (int col = 0; col < n; col++) {
            int sum = row + col;
            int diff = row - col + n;

            if ((colUsed & (1 << col)) != 0 || (sumUsed & (1 << sum)) != 0 || (diffUsed & (1 << diff)) != 0) {
                continue;
            }

            grid[row][col] = 'Q';
            colUsed ^= 1 << col;
            sumUsed ^= 1 << sum;
            diffUsed ^= 1 << diff;
            backTrack(row + 1, grid, colUsed, sumUsed, diffUsed);
            colUsed ^= 1 << col;
            sumUsed ^= 1 << sum;
            diffUsed ^= 1 << diff;
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
        char[][] grid = new char[n][n];
        initGrid(grid);
        ansList = new ArrayList<>();
        backTrack(0, grid, 0, 0, 0);
        return ansList;
    }

}
