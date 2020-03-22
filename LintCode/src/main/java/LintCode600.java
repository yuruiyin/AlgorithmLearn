import java.util.LinkedList;

/**
 * LintCode600
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode600 {

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int minRow = x;
        int maxRow = x;
        int minCol = y;
        int maxCol = y;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        boolean[][] visited = new boolean[m][n];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                minRow = Math.min(minRow, row);
                maxRow = Math.max(maxRow, row);
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);

                for (int j = 0; j < 4; j++) {
                    int nextRow = row + dx[j];
                    int nextCol = col + dy[j];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n ||
                            image[nextRow][nextCol] == '0' || visited[nextRow][nextCol]) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

}
