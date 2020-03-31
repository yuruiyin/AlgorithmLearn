package problem301_400;

/**
 * Problem361
 *
 * @author: yry
 * @date: 2020/3/31
 */
public class Problem361 {

    private int m;
    private int n;

    private int getCount(char[][] grid, int row, int col) {
        // 上
        int ans = 0;
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 'W') {
                break;
            } else if (grid[i][col] == 'E') {
                ans++;
            }
        }

        // 下
        for (int i = row + 1; i < m; i++) {
            if (grid[i][col] == 'W') {
                break;
            } else if (grid[i][col] == 'E') {
                ans++;
            }
        }

        // 左
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == 'W') {
                break;
            } else if (grid[row][j] == 'E') {
                ans++;
            }
        }

        // 左
        for (int j = col + 1; j < n; j++) {
            if (grid[row][j] == 'W') {
                break;
            } else if (grid[row][j] == 'E') {
                ans++;
            }
        }

        return ans;
    }

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int ansMax = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    // 空位才能放炸弹
                    ansMax = Math.max(ansMax, getCount(grid, i, j));
                }
            }
        }

        return ansMax;
    }

}
