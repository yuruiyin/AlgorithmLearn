package problem1101_1200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem1162_1
 *
 * @author: yry
 * @date: 2020/3/29
 */
public class Problem1162_1 {

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        // 将所有的陆地一次性加入到队列中。然后BFS遍历结果的深度就是离陆地最远的海洋
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                for (int j = 0; j < 4; j++) {
                    int nextRow = row + dx[j];
                    int nextCol = col + dy[j];

                    if (nextRow < 0|| nextRow >= n || nextCol < 0 || nextCol >= n ||
                            visited[nextRow][nextCol] || grid[nextRow][nextCol] == 1) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
            ans++;
        }

        return ans - 1;
    }

    public static void main(String[] args) {
//        System.out.println(new Problem1162_1().maxDistance(new int[][]{
//                {1,0,1},{0,0,0},{1,0,1}
//        }));

        System.out.println(new Problem1162_1().maxDistance(new int[][]{
                {1,0,0},{0,0,0},{0,0,0}
        }));
    }

}
