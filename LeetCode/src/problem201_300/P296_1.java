package problem201_300;

public class P296_1 {

    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 分别计算x和y的最小行走距离
        int[] xCountArr = new int[n];
        int[] yCountArr = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    xCountArr[j]++;
                    yCountArr[i]++;
                }
            }
        }

        int xMinSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int x = 0; x < n; x++) {
                int count = xCountArr[x];
                if (count == 0) {
                    continue;
                }
                sum += Math.abs(x - j) * count;
            }

            if (sum < xMinSum) {
                xMinSum = sum;
            }
        }

        int yMinSum = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int y = 0; y < m; y++) {
                int count = yCountArr[y];
                if (count == 0) {
                    continue;
                }
                sum += Math.abs(y - i) * count;
            }

            if (sum < yMinSum) {
                yMinSum = sum;
            }
        }

        return xMinSum + yMinSum;
    }

    public static void main(String[] args) {
        System.out.println(new P296_1().minTotalDistance(new int[][]{
                {1, 1}
        }));
    }

}
