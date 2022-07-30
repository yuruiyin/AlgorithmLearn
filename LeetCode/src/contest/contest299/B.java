package contest.contest299;

import java.lang.reflect.Array;
import java.util.Arrays;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    private long[][] memo;
    private int n;

    private long dp(int cur, int preHas) {
        if (cur == n) {
            return 1;
        }
        if (memo[cur][preHas] != -1) {
            return memo[cur][preHas];
        }

        if (preHas == 0) {
            long choose = (dp(cur + 1, 1)) % MOD;
            long nonChoose = (dp(cur + 1, 0)) % MOD;
            memo[cur][preHas] = (choose + nonChoose) % MOD;
            return memo[cur][preHas];
        }

        memo[cur][preHas] = dp(cur + 1, 0) % MOD;
        return memo[cur][preHas];
    }

    public int countHousePlacements(int n) {
        this.n = n;
        memo = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        long res = dp(0, 0);
        return (int) (((res % MOD) * (res % MOD)) % MOD);
    }

}
