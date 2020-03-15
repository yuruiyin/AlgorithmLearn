package problem601_700;

import java.util.LinkedList;

public class Problem695 {

    private boolean[][] visited;
    private int[][] grid;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private int m;
    private int n;

    private int bfs(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int curRow = node[0];
                int curCol = node[1];
                count++;

                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0|| nextCol >= n ||
                            grid[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }

        }

        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        visited = new boolean[m][n];

        int ansMax = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }

                ansMax = Math.max(ansMax, bfs(i, j));
            }
        }

        return ansMax;
    }

}
