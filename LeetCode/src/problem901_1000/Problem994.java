package problem901_1000;

import java.util.ArrayList;
import java.util.List;

public class Problem994 {

    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;

        while (true) {
            // 取出2的位置
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2 && !visited[i][j]) {
                        visited[i][j] = true;
                        list.add(new int[]{i, j});
                    }
                }
            }

            if (list.isEmpty()) {
                break;
            }

            ans++;
            for (int[] pos : list) {
                int row = pos[0];
                int col = pos[1];

                for (int i = 0; i < 4; i++) {
                    int nextRow = row + dx[i];
                    int nextCol = col + dy[i];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]
                            || grid[nextRow][nextCol] != 1) {
                        continue;
                    }

                    grid[nextRow][nextCol] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(0, ans - 1);
    }

}
