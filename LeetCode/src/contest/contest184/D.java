package contest.contest184;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/12
 */
public class D {

    private static final int MOD = (int) (1e9 + 7);

    private int n;
    private Long[][][][] memo;

    private long dp(int preI, int preJ, int preK, int curRow) {
        if (curRow == n) {
            return 1;
        }

        if (memo[preI][preJ][preK][curRow] != null) {
            return memo[preI][preJ][preK][curRow];
        }

        long ans = 0;
        for (int i = 0; i <= 2; i++) {
            if (i == preI) {
                continue;
            }

            for (int j = 0; j <= 2; j++) {
                if (j == i || j == preJ) {
                    continue;
                }
                for (int k = 0; k <= 2; k++) {
                    if (k == j || k == preK) {
                        continue;
                    }

                    ans = (ans + dp(i, j, k, curRow + 1)) % MOD;
                }
            }
        }

        memo[preI][preJ][preK][curRow]  = ans;
        return ans;
    }

    public int numOfWays(int n) {
        this.n = n;
        if (n == 1) {
            return 12;
        }

        memo = new Long[4][4][4][n + 1];
        long ans = dp(3, 3, 3, 0);
        return (int) (ans % MOD);
    }

}
