package problem501_600;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem542_1
 *
 * @author: yry
 * @date: 2020/4/15
 */
public class Problem542_1 {

    // 把0到全部放到队列里头，然后标记1的位置为一个最大值，然后bfs，bfs过程更新最短路径的长度
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }


        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = m + n;
                }
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int curRow = node[0];
                int curCol = node[1];
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || level >= matrix[nextRow][nextCol]) {
                        continue;
                    }

                    matrix[nextRow][nextCol] = level;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }

        return matrix;
    }

}
