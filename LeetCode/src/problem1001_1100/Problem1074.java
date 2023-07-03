package problem1001_1100;

import java.util.Map;

public class Problem1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preArr = new int[m + 1][n + 1];
        preArr[1][1] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            preArr[i + 1][1] = preArr[i][1] + matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            preArr[1][j + 1] = preArr[1][j] + matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                preArr[i + 1][j + 1] = preArr[i][j + 1] + preArr[i + 1][j] - preArr[i][j] + matrix[i][j];
            }
        }

        int ans = 0;
        for (int x1 = 1; x1 <= m; x1++) {
            for (int y1 = 1; y1 <= n; y1++) {
                int preValue11 = preArr[x1 - 1][y1 - 1];
                for (int x2 = x1; x2 <= m; x2++) {
                    int preValue21 = preArr[x2][y1 - 1];
                    for (int y2 = y1; y2 <= n; y2++) {
                        int sum = preArr[x2][y2] - preValue21 - preArr[x1 - 1][y2] + preValue11;
                        if (sum == target) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

}
