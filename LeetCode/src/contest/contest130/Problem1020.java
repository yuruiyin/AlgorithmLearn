package contest.contest130;

import java.util.LinkedList;

public class Problem1020 {

    private int[][] grid;
    private int m;
    private int n;
    private boolean[][] visited;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    private int bfs(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        int oneCount = 1;
        visited[row][col] = true;
        boolean isOk = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int curRow = node[0];
                int curCol = node[1];
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        // 离开边界
                        isOk = true;
                        continue;
                    }

                    if (grid[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                        continue;
                    }

                    oneCount++;
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        if (!isOk) {
            return oneCount;
        }

        return 0;
    }

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                ans += bfs(i, j);
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1020().numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
    }

}
