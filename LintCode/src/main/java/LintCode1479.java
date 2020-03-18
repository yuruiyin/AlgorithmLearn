/**
 * LintCode1497
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode1479 {

    private int m;
    private int n;
    private int[][] grid;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private boolean dfs(int row, int col, boolean[][] visited) {
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0) {
            return false;
        }

        if (grid[row][col] == 9) {
            return true;
        }

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (dfs(nextRow, nextCol, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean reachEndpoint(int[][] map) {
        grid = map;
        this.m = grid.length;
        this.n = grid[0].length;
        return dfs(0, 0, new boolean[m][n]);
    }

}
