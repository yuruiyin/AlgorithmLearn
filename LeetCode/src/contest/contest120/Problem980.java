package contest.contest120;

public class Problem980 {

    private int[] fromPos;
    private int[] toPos;
    private int zeroCount;
    private int m;
    private int n;
    private int ans = 0;
    private int[][] grid;

    private void dfs(int row, int col, boolean[][] visited, int level) {
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == -1) {
            return;
        }

        if (grid[row][col] == 2) {
            if (level - 1 == zeroCount) {
                ans++;
            }
            return;
        }

        visited[row][col] = true;
        dfs(row - 1, col, visited, level + 1);
        dfs(row + 1, col, visited, level + 1);
        dfs(row, col - 1, visited, level + 1);
        dfs(row, col + 1, visited, level + 1);
        visited[row][col] = false;
    }

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fromPos = new int[]{i, j};
                } else if (grid[i][j] == 2) {
                    toPos = new int[]{i, j};
                } else if (grid[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        dfs(fromPos[0], fromPos[1], new boolean[m][n], 0);
        return ans;
    }

}
