package lcci;

import java.util.LinkedList;

public class Lcci0810 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int targetColor = image[sr][sc];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        boolean[][] visited = new boolean[m][n];
        visited[sr][sc] = true;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                image[row][col] = newColor;

                for (int j = 0; j < 4; j++) {
                    int nextRow = row + dx[j];
                    int nextCol = col + dy[j];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n ||
                            visited[nextRow][nextCol] || image[nextRow][nextCol] != targetColor)  {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }

        return image;
    }

}
