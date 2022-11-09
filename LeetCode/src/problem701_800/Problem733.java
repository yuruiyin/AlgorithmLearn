package problem701_800;

import java.util.LinkedList;

public class Problem733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        LinkedList<int[]> queue = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        queue.add(new int[]{sr, sc});
        boolean[][] visited = new boolean[m][n];
        visited[sr][sc] = true;
        int initValue = image[sr][sc];
        image[sr][sc] = color;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for (int j = 0; j < 4; j++) {
                    int nextX = x + dx[j];
                    int nextY = y + dy[j];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY]
                            || image[nextX][nextY] != initValue) {
                        continue;
                    }
                    image[nextX][nextY] = color;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return image;
    }

}
