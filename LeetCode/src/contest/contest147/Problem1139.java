package contest.contest147;

public class Problem1139 {

    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int largest1BorderedSquare(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        // 每个位置左侧连续1的个数
        int[][] leftOneCountArr = new int[rowCount][colCount];
        // 每个位置上侧连续1的个数
        int[][] topOneCountArr  = new int[rowCount][colCount];
        // 统计出所有1的位置
        Position[] onePositionArr = new Position[rowCount * colCount];
        int oneCount = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    onePositionArr[oneCount++] = new Position(i, j);
                }

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

        for (int k = 0; k < oneCount; k++) {
            Position onePosition = onePositionArr[k];
            int i = onePosition.x;
            int j = onePosition.y;

            if (j < Math.sqrt(maxArea)) {
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

        return maxArea;
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][] {
//                {0,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,1,1,0},{0,1,1,1,1},{1,1,1,0,1},{0,1,1,1,1},{1,1,1,0,1} //9
                {1,1,0},{1,1,1},{1,1,1},{1,1,1} //9
        };
        
        System.out.println(new Problem1139().largest1BorderedSquare(grid)); //9
    }
    
}
