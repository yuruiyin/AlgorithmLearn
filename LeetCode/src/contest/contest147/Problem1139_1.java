package contest.contest147;

public class Problem1139_1 {

    public int largest1BorderedSquare(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] leftOneCountArr = new int[rowCount][colCount];
        int[][] topOneCountArr  = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (j == 0) {
                    leftOneCountArr[i][j] = grid[i][j] == 0 ? 0 : 1;
                }

                if (i == 0) {
                    topOneCountArr[i][j] = grid[i][j] == 0 ? 0 : 1;
                }

                if (j > 0) {
                    leftOneCountArr[i][j] = grid[i][j] == 0 ? 0 : leftOneCountArr[i][j-1] + grid[i][j];
                }

                if (i > 0) {
                    topOneCountArr[i][j] = grid[i][j] == 0 ? 0 : topOneCountArr[i-1][j] + grid[i][j];
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = (int) Math.sqrt(maxArea); j < colCount; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int minSide = Math.min(topOneCountArr[i][j], leftOneCountArr[i][j]);
                if (minSide * minSide <= maxArea) { // 当前可能的最大面积小于目前最大面积，则无需进行一下判断
                    continue;
                }

                int curMax = 1;
                for (int x = j - minSide + 1, y = i - minSide + 1; x < j; x++, y++) {
                    int value = Math.min(topOneCountArr[i][x], leftOneCountArr[y][j]);
                    int sideLen = j - x + 1; //边长
                    if (value >= sideLen) {
                        curMax = sideLen * sideLen;
                        break;
                    }
                }

                if (curMax > maxArea) {
                    maxArea = curMax;
                }
            }
        }

        return maxArea;
    }

}
