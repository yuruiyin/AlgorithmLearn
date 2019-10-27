package problem001_100;

import java.util.Arrays;

public class Problem063 {

    // 最后一行和最后一列障碍物（1）所在的最大位置（最后一行最右的1和最后一列最下的1）
    private int maxObstaclesIndexInLastRow = - 1;
    private int maxObstaclesIndexInLastCol = -1;

    private int[] memo;

    private int backTrack(int[][] grid, int row, int col, int rowCount, int colCount) {
        int key = row * colCount + col;
        if (memo[key] != -1) {
            return memo[key];
        }

        if (grid[row][col] == 1) {
            return 0;
        }

        if (row == rowCount - 1) {
            return col < maxObstaclesIndexInLastRow ? 0 : 1;
        }

        if (col == colCount - 1) {
            return row < maxObstaclesIndexInLastCol ? 0 : 1;
        }

        int ans = backTrack(grid, row + 1, col, rowCount, colCount) + backTrack(grid, row, col + 1, rowCount, colCount);
        memo[key] = ans;
        return ans;
    }

    /**
     * 判断最后一行和最后一列是否有障碍物
     */
    private void checkLastRowAndCol(int[][] grid, int rowCount, int colCount) {
        for (int j = colCount - 2; j >= 0; j--) {
            if (grid[rowCount - 1][j] == 1) {
                maxObstaclesIndexInLastRow = j;
                break;
            }
        }

        for (int i = rowCount - 2; i >= 0; i--) {
            if (grid[i][colCount - 1] == 1) {
                maxObstaclesIndexInLastCol = i;
                break;
            }
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int rowCount = obstacleGrid.length;
        int colCount = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowCount - 1][colCount - 1] == 1) {
            return 0;
        }

        checkLastRowAndCol(obstacleGrid, rowCount, colCount);

        memo = new int[rowCount * colCount];
        Arrays.fill(memo, -1);

        return backTrack(obstacleGrid, 0, 0, rowCount, colCount);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem063().uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));

        System.out.println(new Problem063().uniquePathsWithObstacles(new int[][]{
                {0,1}
        }));
    }
    
}
