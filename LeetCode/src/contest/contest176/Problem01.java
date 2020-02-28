package contest.contest176;

public class Problem01 {

    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
