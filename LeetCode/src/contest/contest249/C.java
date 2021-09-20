package contest.contest249;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/11
 */
public class C {

    private static final int MOD = (int) (1e9 + 7);

    private int rowCount;
    private int colCount;
    private Long[][][] dp;
    private int[][] grid;

    private long rec(int i, int j) {
        if (i == rowCount) {
            return 1;
        }

        if (j == colCount) {
            return rec(i + 1, 0);
        }

        long ans = 0;
        if (i == 0) {
            for (int k = 0; k < 3; k++) {
                if (j > 0 && k == grid[i][j - 1]) {
                    continue;
                }
                grid[i][j] = k;
                ans = (ans + rec(i, j + 1)) % MOD;
            }
        } else {
            int pre = 0;
            for (int k = 0; k < j; k++) {
                pre *= 3;
                pre += grid[i][k];
            }
            for (int k = j; k < colCount; k++) {
                pre *= 3;
                pre += grid[i - 1][k];
            }

            if (dp[i][j][pre] != null) {
                return dp[i][j][pre];
            }

            for (int k = 0; k < 3; k++) {
                if (k == grid[i - 1][j] || (j > 0 && k == grid[i][j - 1])) {
                    continue;
                }
                grid[i][j] = k;
                ans = (ans + rec(i, j + 1)) % MOD;
            }

            dp[i][j][pre] = ans;
        }

        return ans;
    }

    public int colorTheGrid(int m, int n) {
        this.rowCount = n;
        this.colCount = m;
        grid = new int[rowCount][colCount];
        dp = new Long[rowCount][colCount][(int) Math.pow(3, colCount) + 1];
        return (int) (rec(0, 0) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new C().colorTheGrid(1,2));
    }

}
