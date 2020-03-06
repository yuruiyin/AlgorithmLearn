package contest.contest178;

public class Problem04 {

    private int m;
    private int n;
    private int[][] grid;
    private Integer[][] min;
    private int[] dx = new int[]{0, 0, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0};
    private int ansMinCost = Integer.MAX_VALUE;

    private void dfs(int row, int col, int cost) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        if (cost >= ansMinCost || min[row][col] != null && cost >= min[row][col]) {
            return;
        }

        if (row == m - 1 && col == n - 1) {
            ansMinCost = Math.min(ansMinCost, cost);
            return;
        }

        min[row][col] = cost;

        int value = grid[row][col];
        dfs(row + dx[value - 1], col + dy[value - 1], cost);

        for (int i = 1; i <= 4; i++) {
            if (i == value) {
                continue;
            }

            grid[row][col] = i;
            dfs(row + dx[i - 1], col + dy[i - 1], cost + 1);
            grid[row][col] = value;
        }
    }

    public int minCost(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        min = new Integer[m][n];
        dfs(0, 0, 0);
        return ansMinCost;
    }

}
