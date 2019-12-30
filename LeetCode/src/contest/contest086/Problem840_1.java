package contest.contest086;

public class Problem840_1 {

    private boolean isDiff(int[][] grid, int fromRow, int fromCol) {
        boolean[] visited = new boolean[16];
        for (int i = fromRow; i < fromRow + 3; i++) {
            for (int j = fromCol; j < fromCol + 3; j++) {
                if (grid[i][j] >= 10 || grid[i][j] == 0) {
                    return false;
                }
                if (visited[grid[i][j]]) {
                    return false;
                }

                visited[grid[i][j]] = true;
            }
        }

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int ans = 0;

        for (int i = 0; i < rowCount - 2; i++) {
            for (int j = 0; j < colCount - 2; j++) {
                if (!isDiff(grid, i, j)) {
                    continue;
                }

                int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                boolean isSame = true;
                // 行
                for (int k = i + 1; k < i + 3; k++) {
                    int tmpSum = grid[k][j] + grid[k][j+1] + grid[k][j+2];
                    if (tmpSum != sum) {
                        isSame = false;
                        break;
                    }
                }

                if (!isSame) {
                    continue;
                }

                // 列
                for (int l = j; l < j + 3; l++) {
                    int tmpSum = grid[i][l] + grid[i+1][l] + grid[i+2][l];
                    if (tmpSum != sum) {
                        isSame = false;
                        break;
                    }
                }

                if (!isSame) {
                    continue;
                }

                int sum1 = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                if (sum1 != sum) {
                    continue;
                }
                int sum2 = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];
                if (sum2 == sum) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
