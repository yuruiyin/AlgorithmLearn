package problem301_400;

import java.util.LinkedList;

public class Problem302 {

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        int minRow = x;
        int maxRow = x;
        int minCol = y;
        int maxCol = y;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int curRow = node[0];
                int curCol = node[1];

                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0|| nextCol >= n ||
                            image[nextRow][nextCol] == '0' || visited[nextRow][nextCol]) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                    minRow = Math.min(minRow, nextRow);
                    maxRow = Math.max(maxRow, nextRow);
                    minCol = Math.min(minCol, nextCol);
                    maxCol = Math.max(maxCol, nextCol);
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

}
