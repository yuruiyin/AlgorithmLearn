package problem801_900;

public class Problem840 {

    private boolean isNumberLegal(int[][] grid, int i, int j) {
        // 必须是1到9的不同数字
        boolean[] visited = new boolean[16];
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int value = grid[i+k][j+l];
                if (value < 1 || value > 9 || visited[value]) {
                    return false;
                }

                visited[value] = true;
            }
        }

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        if (rowCount < 3 || colCount < 3) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < rowCount - 2; i++) {
            for (int j = 0; j < colCount - 2; j++) {
                if (!isNumberLegal(grid, i, j)) {
                    continue;
                }
                // i，j缺点矩阵左上角顶点
                int firstRowSum = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                boolean isEqual = true;

                // 剩余两行
                for (int k = 1; k < 3; k++) {
                    int sum = grid[i+k][j] + grid[i+k][j+1] + grid[i+k][j+2];
                    if (sum != firstRowSum) {
                        isEqual = false;
                        break;
                    }
                }

                if (!isEqual) {
                    continue;
                }

                // 三列
                for (int k = 0; k < 3; k++) {
                    int sum = grid[i][j+k] + grid[i+1][j+k] + grid[i+2][j+k];
                    if (sum != firstRowSum) {
                        isEqual = false;
                        break;
                    }
                }

                if (!isEqual) {
                    continue;
                }

                //两条对角线
                int sum1 = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                if (sum1 != firstRowSum) {
                    continue;
                }

                int sum2 = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];
                if (sum2 != firstRowSum) {
                    continue;
                }

                ans++;
            }
        }

        return ans;
    }

}
