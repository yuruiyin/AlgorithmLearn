package doubleContest.round56;

import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/10
 */
public class B {

    private int rowCount;
    private int colCount;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private int bfs(int x, int y, char[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowCount][colCount];
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                if ((node[0] == rowCount - 1 || node[0] == 0 || node[1] == 0 || node[1] == colCount - 1) && !(node[0] == x && node[1] == y)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    int nextRow = node[0] + dx[j];
                    int nextCol = node[1] + dy[j];
                    if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount ||
                            grid[nextRow][nextCol] == '+' || visited[nextRow][nextCol]) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
            count++;
        }

        return -1;
    }

    public int nearestExit(char[][] grid, int[] entrance) {
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        return bfs(entrance[0], entrance[1], grid);
    }

}
