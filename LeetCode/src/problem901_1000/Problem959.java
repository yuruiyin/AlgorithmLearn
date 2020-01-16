package problem901_1000;

import java.util.LinkedList;

public class Problem959 {

    // 空格
    private int[][] spaceGrid = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    // /斜杆
    private int[][] slashGrid = new int[][]{
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0}
    };

    // \反斜杆
    private int[][] backslashGrid = new int[][]{
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
    };

    private void createGrid(int[][] grid, char c, int row, int col) {
        int[][] addedGrid;
        if (c == ' ') {
            addedGrid = spaceGrid;
        } else if (c == '/') {
            addedGrid = slashGrid;
        } else {
            // '\\'
            addedGrid = backslashGrid;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[row * 3 + i][col * 3 + j] = addedGrid[i][j];
            }
        }
    }

    private boolean[][] visited;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    private void bfs(int[][] grid, int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        int n = grid.length;
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int curRow = node[0];
                int curCol = node[1];
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];
                    if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n ||
                            grid[nextRow][nextCol] == 1|| visited[nextRow][nextCol]) {
                        continue;
                    }
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }

    public int regionsBySlashes(String[] arr) {
        int len = arr.length;
        int n = 3 * len;
        int[][] grid = new int[n][n];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                createGrid(grid, arr[i].charAt(j), i, j);
            }
        }

        // 选择0的连通分量，就是被分割的区域个数
        int ansCount = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || visited[i][j]) {
                    continue;
                }

                bfs(grid, i, j);
                ansCount++;
            }
        }

        return ansCount;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem959().regionsBySlashes(new String[]{
                " /",
                "/ "
        }));
    }
}
