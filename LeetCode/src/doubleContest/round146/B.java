package doubleContest.round146;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    private Integer[][][] memo;

    private int[][] grid;

    private int m;
    private int n;

    private int k;

    private int rec(int row, int col, int xor) {
        if (row == m - 1 && col == n - 1) {
            if (xor == k) {
                return 1;
            }
            return 0;
        }

        if (memo[row][col][xor] != null) {
            return memo[row][col][xor];
        }

        int bottom = 0;
        if (row < m - 1) {
            bottom = rec(row + 1, col, grid[row + 1][col] ^ xor);
        }

        int right = 0;
        if (col < n - 1) {
            right = rec(row, col + 1, grid[row][col + 1] ^ xor);
        }

        return memo[row][col][xor] = (bottom + right) % MOD;
    }

    public int countPathsWithXorValue(int[][] grid, int k) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.k = k;
        memo = new Integer[m][n][16];
        return rec(0, 0, grid[0][0]);
    }

}
