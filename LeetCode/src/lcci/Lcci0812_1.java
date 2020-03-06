package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 位运算
public class Lcci0812_1 {

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
     *
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
            int oneMoveCol = 1 << col;
            int oneMoveSum = 1 << (row + col);
            int oneMoveDiff = 1 << (row - col + n);

            if ((colUsed & oneMoveCol) != 0 || (sumUsed & oneMoveSum) != 0 || (diffUsed & oneMoveDiff) != 0) {
                continue;
            }

            grid[row][col] = 'Q';
            backTrack(row + 1, grid, colUsed ^ oneMoveCol, sumUsed ^ oneMoveSum, diffUsed ^ oneMoveDiff);
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
