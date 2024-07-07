package contest.contest405;

public class C {

    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][] preXCountArr = new int[m][n];
        int[][] preYCountArr = new int[m][n];
        preXCountArr[0][0] = grid[0][0] == 'X' ? 1 : 0;
        preYCountArr[0][0] = grid[0][0] == 'Y' ? 1 : 0;
        for (int i = 1; i < m; i++) {
            preXCountArr[i][0] = preXCountArr[i - 1][0] + (grid[i][0] == 'X' ? 1 : 0);
            preYCountArr[i][0] = preYCountArr[i - 1][0] + (grid[i][0] == 'Y' ? 1 : 0);
        }

        for (int j = 1; j < n; j++) {
            preXCountArr[0][j] = preXCountArr[0][j - 1] + (grid[0][j] == 'X' ? 1 : 0);
            preYCountArr[0][j] = preYCountArr[0][j - 1] + (grid[0][j] == 'Y' ? 1 : 0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                preXCountArr[i][j] = preXCountArr[i - 1][j] + preXCountArr[i][j - 1] - preXCountArr[i - 1][j - 1] + (grid[i][j] == 'X' ? 1 : 0);
                preYCountArr[i][j] = preYCountArr[i - 1][j] + preYCountArr[i][j - 1] - preYCountArr[i - 1][j - 1] + (grid[i][j] == 'Y' ? 1 : 0);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (preXCountArr[i][j] == preYCountArr[i][j] && preXCountArr[i][j] >= 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
