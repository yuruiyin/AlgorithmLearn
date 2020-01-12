package problem901_1000;

import java.util.LinkedList;

public class Problem934 {

    private int[][] grid;
    private int rowCount;
    private int colCount;
    private boolean[][] visited;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private void bfs(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextRow = node[0] + dx[j];
                    int nextCol = node[1] + dy[j];
                    if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount ||
                            visited[nextRow][nextCol] || grid[nextRow][nextCol] == 0) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }


    private int getDis(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        boolean[][] tmpVisited = new boolean[rowCount][colCount];
        tmpVisited[row][col] = true;

        int dis = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextRow = node[0] + dx[j];
                    int nextCol = node[1] + dy[j];
                    if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount ||
                            tmpVisited[nextRow][nextCol]) {
                        continue;
                    }

                    if (visited[nextRow][nextCol]) {
                        return dis;
                    }

                    tmpVisited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
            dis++;
        }

        return dis;
    }

    public int shortestBridge(int[][] grid) {
        rowCount = grid.length;
        colCount = grid[0].length;
        this.grid = grid;
        int islandNum = 0;
        visited = new boolean[rowCount][colCount];

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                islandNum++;
                if (islandNum == 1) {
                    bfs(i, j);
                } else {
                    // 第二个岛屿
                    int dis = getDis(i, j);
                    minDis = Math.min(minDis, dis);
                }
            }
        }

        return minDis;
    }

}
