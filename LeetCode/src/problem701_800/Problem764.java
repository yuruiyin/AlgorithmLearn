package problem701_800;

import java.util.Arrays;

public class Problem764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], 1);
        }
        for (int i = mines.length - 1; i >= 0; i--) {
            int[] pos = mines[i];
            grid[pos[0]][pos[1]] = 0;
        }

        int[][] leftContinueOneCountArr = new int[n][n];
        int[][] topContinueOneCountArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            leftContinueOneCountArr[i][0] = grid[i][0];
        }
        for (int j = 0; j < n; j++) {
            topContinueOneCountArr[0][j] = grid[0][j];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                leftContinueOneCountArr[i][j] = grid[i][j] == 0 ? 0 : leftContinueOneCountArr[i][j - 1] + 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                topContinueOneCountArr[i][j] = grid[i][j] == 0 ? 0 : topContinueOneCountArr[i - 1][j] + 1;
            }
        }

        int[][] rightContinueOneCountArr = new int[n][n];
        int[][] bottomContinueOneCountArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            rightContinueOneCountArr[i][n - 1] = grid[i][n - 1];
        }
        for (int j = 0; j < n; j++) {
            bottomContinueOneCountArr[n - 1][j] = grid[n - 1][j];
        }

        for (int i = 0; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                rightContinueOneCountArr[i][j] = grid[i][j] == 0 ? 0 : rightContinueOneCountArr[i][j + 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                bottomContinueOneCountArr[i][j] = grid[i][j] == 0 ? 0 : bottomContinueOneCountArr[i + 1][j] + 1;
            }
        }

        int ansMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int left = j == 0 ? 0 : leftContinueOneCountArr[i][j - 1];
                int top = i == 0 ? 0 : topContinueOneCountArr[i - 1][j];
                int right = j == n - 1 ? 0 : rightContinueOneCountArr[i][j + 1];
                int bottom = i == n - 1 ? 0 : bottomContinueOneCountArr[i + 1][j];
                ansMax = Math.max(ansMax, Math.min(Math.min(left, right), Math.min(top, bottom)) + 1);
            }
        }

        return ansMax;
    }

}
