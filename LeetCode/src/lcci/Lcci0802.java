package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcci0802 {

    private int m;
    private int n;
    private int[][] grid;

    private boolean dfs(int row, int col, boolean[][] visited, List<List<Integer>> pathList) {
        if (row >= m || col >= n || grid[row][col] == 1 || visited[row][col]) {
            return false;
        }

        pathList.add(Arrays.asList(row, col));
        if (row == m - 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;

        if (dfs(row + 1, col, visited, pathList) || dfs(row, col + 1, visited, pathList)) {
            return true;
        }

        pathList.remove(pathList.size() - 1);
        return false;
    }

    public List<List<Integer>> pathWithObstacles(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        List<List<Integer>> ansList = new ArrayList<>();
        dfs(0, 0, new boolean[m][n], ansList);
        return ansList;
    }

}
