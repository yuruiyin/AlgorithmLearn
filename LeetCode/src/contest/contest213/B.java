package contest.contest213;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
class B {
    private int[][] memo;
    private int n;

    private int dfs(int curIdx, int c) {
        if (curIdx == n) {
            return 1;
        }

        if (memo[curIdx][c] != -1) {
            return memo[curIdx][c];
        }

        int ans = 0;
        for (int i = c; i < 5; i++) {
            ans += dfs(curIdx + 1, i);
        }

        memo[curIdx][c] = ans;
        return ans;
    }

    public int countVowelStrings(int n) {
        this.n = n;
        memo = new int[n][5];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += dfs(1, i);
        }

        return ans;
    }
}
