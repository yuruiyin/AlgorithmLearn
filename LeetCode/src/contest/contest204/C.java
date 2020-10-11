package contest.contest204;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/30
 */
public class C {

    boolean[][] visited;
    private int[][] grid;
    private int rowCount;
    private int colCount;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private void bfs(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curNode = queue.poll();
                int curRow = curNode[0];
                int curCol = curNode[1];
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];
                    if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount
                            || visited[nextRow][nextCol] || grid[nextRow][nextCol] == 0) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

    }

    private int getCount() {
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(visited[i], false);
        }
        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                bfs(i, j);
                count++;
            }
        }

        return count;
    }

    public int minDays(int[][] grid) {
        rowCount = grid.length;
        colCount = grid[0].length;
        this.grid = grid;
        visited = new boolean[rowCount][colCount];
        int count = getCount();

        if (count > 1) {
            return 0;
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int tmpCount = getCount();
                    if (tmpCount > 1) {
                        return 1;
                    }

                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

}

//  1 <= grid.length, grid[i].length <= 30
//  grid[i][j] 为 0 或 1
