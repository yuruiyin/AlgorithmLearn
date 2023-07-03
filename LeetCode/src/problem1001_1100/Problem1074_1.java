package problem1001_1100;

import java.util.HashMap;
import java.util.Map;

public class Problem1074_1 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preRowArr = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preRowArr[i][j] = preRowArr[i][j - 1] + matrix[i - 1][j - 1];
            }
        }

        // 纵坐标[x1, y1]之间
        int ans = 0;
        for (int y1 = 1; y1 <= n; y1++) {
            for (int y2 = y1; y2 <= n; y2++) {
                Map<Integer, Integer> countMap = new HashMap<>();
                countMap.put(0, 1);
                int sum = 0;
                for (int x = 1; x <= m; x++) {
                    sum += preRowArr[x][y2] - preRowArr[x][y1 - 1];
                    ans += countMap.getOrDefault(sum - target, 0);
                    countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }

}
