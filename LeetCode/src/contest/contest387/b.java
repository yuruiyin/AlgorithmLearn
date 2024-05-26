package contest.contest387;

public class b {

    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] preSumArr = new long[m][n];
        int ans = 0;
        preSumArr[0][0] = grid[0][0];
        if (preSumArr[0][0] <= k) {
            ans++;
        }
        for (int j = 1; j < n; j++) {
            preSumArr[0][j] = preSumArr[0][j - 1] + grid[0][j];
            if (preSumArr[0][j] <= k) {
                ans++;
            }
        }
        for (int i = 1; i < m; i++) {
            preSumArr[i][0] = preSumArr[i - 1][0] + grid[i][0];
            if (preSumArr[i][0] <= k) {
                ans++;
            }
            for (int j = 1; j < n; j++) {
                preSumArr[i][j] = preSumArr[i - 1][j] + preSumArr[i][j-1] + grid[i][j] - preSumArr[i-1][j-1];
                if (preSumArr[i][j] <= k) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
