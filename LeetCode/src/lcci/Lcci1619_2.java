package lcci;

import java.util.*;

public class Lcci1619_2 {

    private int rowCount;
    private int colCount;

    private void calc(int[][] grid, ArrayDeque<int[]> queue, int nextR, int nextC) {
        if (nextR < 0 || nextR >= rowCount || nextC < 0 || nextC >= colCount || grid[nextR][nextC] != 0) {
            return;
        }
        grid[nextR][nextC] = -1;
        queue.add(new int[]{nextR, nextC});
    }

    // 使用数组优化LinkedList实现bfs
    private int bfs(int[][] grid, int r, int c) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        grid[r][c] = -1;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curR = node[0];
            int curC = node[1];
            count++;
            calc(grid, queue, curR - 1, curC - 1);
            calc(grid, queue, curR - 1, curC);
            calc(grid, queue, curR - 1, curC + 1);
            calc(grid, queue, curR, curC - 1);
            calc(grid, queue, curR, curC + 1);
            calc(grid, queue, curR + 1, curC - 1);
            calc(grid, queue, curR + 1, curC);
            calc(grid, queue, curR + 1, curC + 1);
        }
        return count;
    }

    public int[] pondSizes(int[][] land) {
        this.rowCount = land.length;
        this.colCount = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
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
