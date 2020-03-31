package problem601_700;

/**
 * Problem661
 *
 * @author: yry
 * @date: 2020/3/31
 */
public class Problem661 {

    private int m;
    private int n;

    private boolean isOk(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    private int calcDegree(int[][] grid, int row, int col) {
        int count = 0;
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isOk(row + i, col + j)) {
                    count++;
                    sum += grid[row + i][col + j];
                }
            }
        }

        return sum / count;
    }

    public int[][] imageSmoother(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] ansGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ansGrid[i][j] = calcDegree(grid, i, j);
            }
        }

        return ansGrid;
    }

}
