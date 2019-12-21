package problem201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem286_1 {

    private int[][] rooms;
    private int rowCount;
    private int colCount;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private void bfs(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        int dis = 0;

        while (!queue.isEmpty()) {
            List<int[]> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            dis++;

            for (int[] node: nodeList) {
                int i = node[0];
                int j = node[1];

                for (int k = 0; k < 4; k++) {
                    int nextRow = i + dx[k];
                    int nextCol = j + dy[k];

                    if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount &&
                            dis < rooms[nextRow][nextCol]) {
                        rooms[nextRow][nextCol] = dis;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        this.rooms = rooms;
        this.rowCount = rooms.length;
        this.colCount = rooms[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (rooms[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
    }

}
