package problem401_500;

public class Problem463 {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                int initValue = 4;
                if (i > 0 && grid[i-1][j] == 1) {
                    initValue--;
                }

                if (i < m - 1 && grid[i+1][j] == 1) {
                    initValue--;
                }

                if (j > 0 && grid[i][j - 1] == 1) {
                    initValue--;
                }

                if (j < n - 1 && grid[i][j+1] == 1) {
                    initValue--;
                }

                ans += initValue;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem463().islandPerimeter(new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        }));
    }
    
}
