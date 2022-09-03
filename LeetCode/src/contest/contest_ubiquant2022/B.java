package contest.contest_ubiquant2022;

public class B {

    private int rowCount;
    private int colCount;

    private void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= rowCount || c < 0 || c >= colCount || visited[r][c] || grid[r][c] == '.') {
            return;
        }
        visited[r][c] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dfs(grid, r + i, c + j, visited);
            }
        }
    }

    public int lakeCount(String[] field) {
        this.rowCount = field.length;
        this.colCount = field[0].length();
        char[][] grid = new char[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            grid[i] = field[i].toCharArray();
        }

        boolean[][] visited = new boolean[rowCount][colCount];
        int ans = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == '.' || visited[i][j]) {
                    continue;
                }
                dfs(grid, i, j, visited);
                ans++;
            }
        }
        return ans;
    }

}
