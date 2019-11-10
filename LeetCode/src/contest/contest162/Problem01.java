package contest.contest162;

public class Problem01 {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] grid = new int[n][m];
        for (int[] indice: indices) {
            int row = indice[0];
            int col = indice[1];

            for (int j = 0; j < m; j++) {
                grid[row][j]++;
            }

            for (int i = 0; i < n; i++) {
                grid[i][col]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] % 2 == 1) {
                    ans++;
                }
            }
        }

        return  ans;
    }
    
    public static void main(String[] args) {

    }
    
}
