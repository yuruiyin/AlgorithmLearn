package lcof;

public class Lcof047_1 {

    private int[][] grid;
    private int m;
    private int n;
    private int[][] memo;

    private int dp(int row, int col) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        // 向右或向下取最大值
        int rightMax = 0;
        int bottomMax = 0;

        if (col < n - 1) {
            rightMax = dp(row, col + 1);
        }

        if (row < m - 1) {
            bottomMax = dp(row + 1, col);
        }

        int max = Math.max(rightMax, bottomMax) + grid[row][col];
        memo[row][col] = max;
        return max;
    }

    public int maxValue(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        memo = new int[m][n];
        return dp(0, 0);
    }

}
