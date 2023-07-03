package contest.contest340;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class D_1 {

    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], (int) 2e9);
        }
        LinkedList<int[]> queue = new LinkedList<>();
        cost[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] top = queue.pollFirst();
            int row = top[0];
            int col = top[1];
            if (row == m - 1 && col == n - 1) {
                return cost[row][col];
            }
            // 向右
            for (int nextCol = col + 1; nextCol <= grid[row][col] + col && nextCol < n; nextCol++) {
                if (cost[row][col] + 1 < cost[row][nextCol]) {
                    cost[row][nextCol] = cost[row][col] + 1;
                    queue.addLast(new int[]{row, nextCol});
                }
            }

            // 向下
            for (int nextRow = row + 1; nextRow <= grid[row][col] + row && nextRow < m; nextRow++) {
                if (cost[row][col] + 1 < cost[nextRow][col]) {
                    cost[nextRow][col] = cost[row][col] + 1;
                    queue.addLast(new int[]{nextRow, col});
                }
            }
        }

        return -1;
    }

}
