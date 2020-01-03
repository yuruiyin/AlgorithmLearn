package contest.contest099;

public class Problem892_1 {

    public int surfaceArea(int[][] grid) {
        int sum = 0;
        int rowCount = grid.length;
        int colCount = grid[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] != 0) {
                    sum += 2;
                }

                // 上下
                if (i == 0) {
                    sum += grid[i][j];
                }

                if (i == rowCount - 1) {
                    sum += grid[i][j];
                }

                if (i > 0 && i <= rowCount - 1) {
                    sum += Math.abs(grid[i][j] - grid[i-1][j]);
                }

                // 左右
                if (j == 0) {
                    sum += grid[i][j];
                }

                if (j == colCount - 1) {
                    sum += grid[i][j];
                }

                if (j > 0 && j <= colCount - 1) {
                    sum += Math.abs(grid[i][j] - grid[i][j-1]);
                }
            }
        }

        return sum;
    }

}
