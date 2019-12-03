package problem101_200;

public class Problem200_1 {

    private int rowCount;
    private int colCount;
    private  boolean[][] visited;
    private char[][] grid;

    private void dfs(int row, int col) {
        if (row >= rowCount || row < 0 || col >= colCount || col < 0 || visited[row][col] || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;
        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
    }

    public int numIslands(char[][] grid) {
        // bfs
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        this.grid = grid;
        rowCount = grid.length;
        colCount = grid[0].length;
        visited = new boolean[rowCount][colCount];

        int ans = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }

                dfs(i, j);
                ans++;
            }
        }

        return ans;
    }

}
