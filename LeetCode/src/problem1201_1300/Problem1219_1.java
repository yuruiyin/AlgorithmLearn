package problem1201_1300;

public class Problem1219_1 {

    private int m;
    private int n;
    private int[][] grid;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private int rec(int row, int col) {
        int curCount = grid[row][col];
        grid[row][col] = 0;
        int ansMax = 0;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] == 0) {
                continue;
            }

            ansMax = Math.max(ansMax, rec(nextRow, nextCol));
        }

        grid[row][col] = curCount;
        return ansMax + curCount;
    }

    public int getMaximumGold(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        int ansMax = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                ansMax = Math.max(ansMax, rec(i, j));
            }
        }

        return ansMax;
    }

}
