package problem101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem200 {

    private int rowCount;
    private int colCount;
    private  boolean[][] visited;
    private char[][] grid;

    private void bfs(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            List<int[]> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            for (int[] node : nodeList) {
                int i = node[0];
                int j = node[1];

                // 上
                if (i > 0 && grid[i-1][j] == '1' && !visited[i-1][j]) {
                    queue.add(new int[]{i-1, j});
                    visited[i-1][j] = true;
                }

                // 下
                if (i < rowCount - 1 && grid[i+1][j] == '1' && !visited[i+1][j]) {
                    queue.add(new int[]{i+1, j});
                    visited[i+1][j] = true;
                }

                // 左
                if (j > 0 && grid[i][j-1] == '1' && !visited[i][j-1]) {
                    queue.add(new int[]{i, j-1});
                    visited[i][j-1] = true;
                }

                // 右
                if (j < colCount - 1 && grid[i][j+1] == '1' && !visited[i][j+1]) {
                    queue.add(new int[]{i, j+1});
                    visited[i][j+1] = true;
                }
            }
        }
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

                bfs(i, j);
                ans++;
            }
        }

        return ans;
    }

}
