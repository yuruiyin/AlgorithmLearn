package contest.contest367;

public class D_1 {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int m = grid.length;
        int n = grid[0].length;

        int[][] suf = new int[m][n];
        long mul = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                suf[i][j] = (int) mul;
                mul = (mul * grid[i][j]) % mod;
            }
        }

        long pre = 1;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = (int) ((pre * suf[i][j]) % mod);
                pre = (pre * grid[i][j]) % mod;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[][] ans = new D().constructProductMatrix(new int[][]{
//                {1,2}, {3,4}
//        });
    }

}
