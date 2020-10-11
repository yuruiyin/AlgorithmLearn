package doubleContest.round33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/22
 */
public class D {

    private boolean[][] visited;
    private char[][] grid;
    private int m;
    private int n;
    private boolean isFound = false;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private void dfs(int row, int col, char c, int level, List<int[]> pathList) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != c) {
            return;
        }

        if (visited[row][col]) {
            if (level >= 4 && !Arrays.equals(pathList.get(pathList.size() - 3), new int[]{row, col})) {
                isFound = true;
            }
            return;
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            pathList.add(new int[]{nextRow, nextCol});
            dfs(nextRow, nextCol, c, level + 1, pathList);
            pathList.remove(pathList.size() - 1);
        }
    }

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }

                List<int[]> pathList = new ArrayList<>();
                pathList.add(new int[]{i, j});
                dfs(i, j, grid[i][j], 0, pathList);
                if (isFound) {
                    return true;
                }
            }
        }

        return false;
    }

}
