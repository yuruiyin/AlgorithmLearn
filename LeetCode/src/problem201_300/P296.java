package problem201_300;

import java.util.HashMap;
import java.util.Map;

public class P296 {

    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 分别计算x和y的最小行走距离
        Map<Integer, Integer> xCountMap = new HashMap<>();
        Map<Integer, Integer> yCountMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    xCountMap.put(j, xCountMap.getOrDefault(j, 0) + 1);
                    yCountMap.put(i, yCountMap.getOrDefault(i, 0) + 1);
                }
            }
        }

        int xMinSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int x : xCountMap.keySet()) {
                int count = xCountMap.get(x);
                sum += Math.abs(x - j) * count;
            }

            if (sum < xMinSum) {
                xMinSum = sum;
            }
        }

        int yMinSum = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int y : yCountMap.keySet()) {
                int count = yCountMap.get(y);
                sum += Math.abs(y - i) * count;
            }

            if (sum < yMinSum) {
                yMinSum = sum;
            }
        }

        return xMinSum + yMinSum;
    }

}
