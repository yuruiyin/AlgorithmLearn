package doubleContest.round130;

public class A {

    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m - 1; i++) {
                if (grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
