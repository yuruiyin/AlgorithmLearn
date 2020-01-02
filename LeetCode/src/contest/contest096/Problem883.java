package contest.contest096;

public class Problem883 {

    public int projectionArea(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int sum = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] > 0) {
                    sum++;
                }
            }
        }

        for (int i = 0; i < rowCount; i++) {
            int max = 0;
            for (int j = 0; j < colCount; j++) {
                max = Math.max(max, grid[i][j]);
            }
            sum += max;
        }

        for (int j = 0; j < colCount; j++) {
            int max = 0;
            for (int i = 0; i < rowCount; i++) {
                max = Math.max(max, grid[i][j]);
            }
            sum += max;
        }

        return sum;
    }

}
