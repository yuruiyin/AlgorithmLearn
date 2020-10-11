package contest.contest207;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/20
 */
public class C_1 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxProductPath(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        long[][] positiveDp = new long[rowCount][colCount];
        long[][] negativeDp = new long[rowCount][colCount];

        if (grid[0][0] >= 0) {
            positiveDp[0][0] = grid[0][0];
        } else {
            negativeDp[0][0] = grid[0][0];
        }

        for (int i = 1; i < rowCount; i++) {
            long res1 = positiveDp[i - 1][0] * grid[i][0];
            long res2 = negativeDp[i - 1][0] * grid[i][0];
            negativeDp[i][0] = Math.min(res1, res2);
            positiveDp[i][0] = Math.max(res1, res2);
        }

        for (int j = 1; j < colCount; j++) {
            long res1 = positiveDp[0][j - 1] * grid[0][j];
            long res2 = negativeDp[0][j - 1] * grid[0][j];
            negativeDp[0][j] = Math.min(res1, res2);
            positiveDp[0][j] = Math.max(res1, res2);
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                long res1 = positiveDp[i][j - 1] * grid[i][j];
                long res2 = negativeDp[i][j - 1] * grid[i][j];
                long res3 = positiveDp[i-1][j] * grid[i][j];
                long res4 = negativeDp[i-1][j] * grid[i][j];

                negativeDp[i][j] = Math.min(Math.min(res1, res2), Math.min(res3, res4));
                positiveDp[i][j] = Math.max(Math.max(res1, res2), Math.max(res3, res4));
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 0 && positiveDp[rowCount - 1][colCount - 1] == 0) {
                    return 0;
                }
            }
        }

        return positiveDp[rowCount - 1][colCount - 1] == 0 ? -1 : (int) (positiveDp[rowCount - 1][colCount - 1] % MOD);
    }

}
