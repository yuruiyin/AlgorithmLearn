package contest.contest244;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/6
 */
public class A {

    private boolean isSame(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] != grid2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        if (isSame(mat, target)) {
            return true;
        }

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = mat[n - j - 1][i];
            }
        }

        if (isSame(grid, target)) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = mat[n - i - 1][n - j - 1];
            }
        }

        if (isSame(grid, target)) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = mat[j][n - i - 1];
            }
        }

        if (isSame(grid, target)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0, 0},
                {1, 0}
        };

        int[][] target = new int[][]{
                {1, 0},
                {0, 0}
        };

        System.out.println(new A().findRotation(mat, target));
        System.out.println("hello world");
    }

}
