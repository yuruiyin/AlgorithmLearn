package contest.contest313;

public class B {

    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ansMax = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                ansMax = Math.max(ansMax, sum);
            }
        }
        return ansMax;
    }

}
