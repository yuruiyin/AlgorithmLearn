package problem401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem490
 *
 * @author: yry
 * @date: 2020/3/31
 */
public class Problem490 {

    private int[][] maze;
    private int m;
    private int n;
    private int[] destination;

    private List<int[]> getNextPos(int row, int col) {
        List<int[]> list = new ArrayList<>();
        // 上
        int topRow = row;
        for (int i = row - 1; i >= 0; i--) {
            if (maze[i][col] == 1) {
                break;
            }
            topRow = i;
        }

        if (topRow != row) {
            list.add(new int[]{topRow, col});
        }

        // 下
        int bottomRow = row;
        for (int i = row + 1; i < m; i++) {
            if (maze[i][col] == 1) {
                break;
            }
            bottomRow = i;
        }

        if (bottomRow != row) {
            list.add(new int[]{bottomRow, col});
        }

        // 左
        int leftCol = col;
        for (int j = col - 1; j >= 0; j--) {
            if (maze[row][j] == 1) {
                break;
            }
            leftCol = j;
        }

        if (leftCol != col) {
            list.add(new int[]{row, leftCol});
        }

        // 右
        int rightCol = col;
        for (int j = col + 1; j < n; j++) {
            if (maze[row][j] == 1) {
                break;
            }
            rightCol = j;
        }

        if (rightCol != col) {
            list.add(new int[]{row, rightCol});
        }

        return list;
    }

    private boolean dfs(int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        if (row == destination[0] && col == destination[1]) {
            return true;
        }

        List<int[]> nextPosList = getNextPos(row, col);
        for (int[] pos : nextPosList) {
            int nextRow = pos[0];
            int nextCol = pos[1];
            if (visited[nextRow][nextCol]) {
                continue;
            }

            if (dfs(nextRow, nextCol, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }

        this.maze = maze;
        m = maze.length;
        n = maze[0].length;
        this.destination = destination;

        return dfs(start[0], start[1], new boolean[m][n]);
    }

}
