package contest.contest188;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/10
 */
public class D {

    private static final int MOD = 1000000007;

    private int[][] preCountArr;
    private int m;
    private int n;
    private long[][][] memo;

    private int getGridCount(int x1, int y1, int x2, int y2) {
        return preCountArr[x2 + 1][y2 + 1] - preCountArr[x2 + 1][y1] - preCountArr[x1][y2 + 1] + preCountArr[x1][y1];
    }

    private long dp(int x1, int y1, int k) {
        int count = getGridCount(x1, y1, m - 1, n - 1);
        if (k == 1) {
            return count >= 1 ? 1: 0;
        }

        if (count < k) {
            return 0;
        }

        if (memo[x1][y1][k] != -1) {
            return memo[x1][y1][k];
        }

        // 横切
        long ans = 0;
        boolean preHasApple = false;
        for (int i = x1; i < m - 1; i++) {
            if (!preHasApple && getGridCount(x1, y1, i, n - 1) < 1) {
                continue;
            }
            preHasApple = true;
            ans = (ans + dp(i + 1, y1, k - 1)) % MOD;
        }

        // 竖切
        preHasApple = false;
        for (int j = y1; j < n - 1; j++) {
            if (!preHasApple && getGridCount(x1, y1, m - 1, j) < 1) {
                continue;
            }
            preHasApple = true;
            ans = (ans + dp(x1, j + 1, k - 1)) % MOD;
        }

        memo[x1][y1][k] = ans;
        return ans;
    }

    private void calcPreCountArr(int[][] grid) {
        preCountArr = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preCountArr[i][j] = preCountArr[i-1][j] + preCountArr[i][j-1] - preCountArr[i-1][j-1] + grid[i-1][j-1];
            }
        }
    }

    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = pizza[i].charAt(j) == 'A' ? 1 : 0;
            }
        }

        calcPreCountArr(grid);
        memo = new long[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (int) (dp(0, 0, k) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new D().ways(new String[]{
                "A..","AAA","..."
        }, 3));
    }

}
