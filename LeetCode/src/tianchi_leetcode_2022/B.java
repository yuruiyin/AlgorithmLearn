package tianchi_leetcode_2022;

public class B {

    private void dfs(int from, int r, int c, char[][] grid, int m, int n, int[][] visited) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }

        visited[r][c]++;

        // 0-上，1-右，2-下，3-左
        if (from == 0) {
            if (grid[r][c] == '.') {
                dfs(from, r + 1, c, grid, m, n, visited);
            } else if (grid[r][c] == 'L') {
                dfs(3, r, c + 1, grid, m, n, visited);
            } else {
                dfs(1, r, c - 1, grid, m, n, visited);
            }
        } else if (from == 1) {
            if (grid[r][c] == '.') {
                dfs(from, r, c - 1, grid, m, n, visited);
            } else if (grid[r][c] == 'L') {
                dfs(2, r - 1, c, grid, m, n, visited);
            } else {
                dfs(0, r + 1, c, grid, m, n, visited);
            }
        } else if (from == 2) {
            if (grid[r][c] == '.') {
                dfs(from, r - 1, c, grid, m, n, visited);
            } else if (grid[r][c] == 'L') {
                dfs(1, r, c - 1, grid, m, n, visited);
            } else {
                dfs(3, r, c + 1, grid, m, n, visited);
            }
        } else {
            if (grid[r][c] == '.') {
                dfs(from, r, c + 1, grid, m, n, visited);
            } else if (grid[r][c] == 'L') {
                dfs(0, r + 1, c, grid, m, n, visited);
            } else {
                dfs(2, r - 1, c, grid, m, n, visited);
            }
        }

    }

    public int getLength(String[] grid) {
//        '.' 表示空白区域，不改变光的传播方向
//        'R' 表示向右倾斜的 双面 均可反射光线的镜子，改变光的传播方向
//        'L' 表示向左倾斜的 双面 均可反射光线的镜子，改变光的传播方向
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length();
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = grid[i].toCharArray();
        }

        int[][] visited = new int[m][n];
        dfs(0, 0, 0, arr, m, n, visited);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += visited[i][j];
            }
        }
        return ans;
    }

}
