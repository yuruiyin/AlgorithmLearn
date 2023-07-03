package lcci;

import java.util.*;

public class Lcci1619 {

    private static final int[][] d = new int[][]{ {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1} };

    private int bfs(int[][] grid, int r, int c) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        grid[r][c] = -1;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curR = node[0];
            int curC = node[1];
            count++;
            for (int j = 0; j < 8; j++) {
                int nextR = curR + d[j][0];
                int nextC = curC + d[j][1];
                if (nextR < 0 || nextR >= rowCount || nextC < 0 || nextC >= colCount || grid[nextR][nextC] != 0) {
                    continue;
                }
                grid[nextR][nextC] = -1;
                queue.add(new int[]{nextR, nextC});
            }
        }
        return count;
    }

    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] != 0) {
                    continue;
                }
                list.add(bfs(land, i, j));
            }
        }
        int size = list.size();
        int[] ansArr = new int[size];
        for (int i = 0; i < size; i++) {
            ansArr[i] = list.get(i);
        }
        Arrays.sort(ansArr);
        return ansArr;
    }

}
