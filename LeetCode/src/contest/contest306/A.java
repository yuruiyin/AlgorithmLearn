package contest.contest306;

public class A {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ansGrid = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int max = 0;
                for (int r = i; r <= i + 2; r++) {
                    for (int c = j; c <= j + 2; c++) {
                        max = Math.max(max, grid[r][c]);
                    }
                }
                ansGrid[i][j] = max;
            }
        }
        return ansGrid;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
