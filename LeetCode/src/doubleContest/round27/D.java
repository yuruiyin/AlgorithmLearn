package doubleContest.round27;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/30
 */
public class D {

    private int rowCount;
    private int colCount;
    private Integer[][][] memo;
    private int[][] grid;

    private int dp(int curCol1, int curCol2, int curRow) {
        if (curRow == rowCount) {
            return 0;
        }

        if (memo[curCol1][curCol2][curRow] != null) {
            return memo[curCol1][curCol2][curRow];
        }

        int ans = 0;
        if (curCol1 == curCol2) {
            ans += grid[curRow][curCol1];
        } else {
            ans += grid[curRow][curCol1] + grid[curRow][curCol2];
        }

        int max = 0;
        for (int dy1 = -1; dy1 <= 1; dy1++) {
            int nextCol1 = curCol1 + dy1;
            if (nextCol1 < 0 || nextCol1 >= colCount) {
                continue;
            }
            for (int dy2 = -1; dy2 <= 1; dy2++) {
                int nextCol2 = curCol2 + dy2;
                if (nextCol2 < 0 || nextCol2 >= colCount) {
                    continue;
                }
                max = Math.max(max, dp(nextCol1, nextCol2, curRow + 1));
            }
        }

        ans += max;
        memo[curCol1][curCol2][curRow] = ans;
        memo[curCol2][curCol1][curRow] = ans;
        return ans;
    }

    public int cherryPickup(int[][] grid) {
        rowCount = grid.length;
        colCount = grid[0].length;
        this.grid = grid;

        memo = new Integer[colCount][colCount][rowCount];
        return dp(0, colCount - 1, 0);
    }

}
