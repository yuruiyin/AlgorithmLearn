package problem1201_1300;

public class Problem1219 {

    private int totalSum = Integer.MIN_VALUE;

    private void getMaxDfs(int[][] grid, boolean[][] visit, int i, int j, int curSum) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visit[i][j] || grid[i][j] == 0) {
            totalSum = Math.max(totalSum, curSum);
            return;
        }

        visit[i][j] = true;
        getMaxDfs(grid, visit, i, j - 1, curSum + grid[i][j]);
        getMaxDfs(grid, visit, i - 1, j, curSum + grid[i][j]);
        getMaxDfs(grid, visit, i, j + 1, curSum + grid[i][j]);
        getMaxDfs(grid, visit, i + 1, j, curSum + grid[i][j]);
        visit[i][j] = false;
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                getMaxDfs(grid, new boolean[m][n], i, j, 0);
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];

        grid[0] = new int[]{0, 6, 0};
        grid[1] = new int[]{5, 8, 7};
        grid[2] = new int[]{0, 9, 0};

        System.out.println(new Problem1219().getMaximumGold(grid));
    }

}
