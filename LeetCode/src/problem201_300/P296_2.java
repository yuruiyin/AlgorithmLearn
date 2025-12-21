package problem201_300;

public class P296_2 {

    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 分别计算x和y的最小行走距离
        int[] xCountArr = new int[n];
        int[] yCountArr = new int[m];
        int[] xIdxArr = new int[n];
        int xIdxArrLen = 0;
        int[] yIdxArr = new int[m];
        int yIdxArrLen = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    xCountArr[j]++;
                    if (xCountArr[j] == 1) {
                        xIdxArr[xIdxArrLen++] = j;
                    }
                    yCountArr[i]++;
                    if (yCountArr[i] == 1) {
                        yIdxArr[yIdxArrLen++] = i;
                    }
                }
            }
        }

        int xMinSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int jj = 0; jj < xIdxArrLen; jj++) {
                int x = xIdxArr[jj];
                sum += Math.abs(x - j) * xCountArr[x];
            }

            if (sum < xMinSum) {
                xMinSum = sum;
            }
        }

        int yMinSum = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int ii = 0; ii < yIdxArrLen; ii++) {
                int y = yIdxArr[ii];
                sum += Math.abs(y - i) * yCountArr[y];
            }

            if (sum < yMinSum) {
                yMinSum = sum;
            }
        }

        return xMinSum + yMinSum;
    }

    public static void main(String[] args) {
        System.out.println(new P296_2().minTotalDistance(new int[][]{
                {1, 1}
        }));
    }

}
