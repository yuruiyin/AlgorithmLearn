package problem501_600;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem542
 *
 * @author: yry
 * @date: 2020/4/15
 */
public class Problem542 {

    private List<int[]> getAllZeroPosList(int[][] matrix, int m, int n) {
        List<int[]> zeroPosList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroPosList.add(new int[]{i, j});
                }
            }
        }
        return zeroPosList;
    }

    private int dis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        // 从1开始bfs
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> zeroPosList = getAllZeroPosList(matrix, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                int minDis = Integer.MAX_VALUE;
                for (int[] zeroPos : zeroPosList) {
                    minDis = Math.min(minDis, dis(i, j, zeroPos[0], zeroPos[1]));
                }

                matrix[i][j] = minDis;
            }
        }

        return matrix;
    }

}
