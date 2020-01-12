package contest.contest109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem935_1 {

    private static final int MOD = (int) (1e9 + 7);

    private List<Integer>[] nextListArr;
    private int[][] memo;

    private int backTrack(int n, int from) {
        if (n == 1) {
            return 1;
        }

        if (memo[n][from] != -1) {
            return memo[n][from];
        }

        long ans = 0;
        for (Integer next: nextListArr[from]) {
            ans = (ans + backTrack(n - 1, next)) % MOD;
        }

        memo[n][from] = (int) ans;
        return memo[n][from];
    }

    public int knightDialer(int n) {
        nextListArr = new ArrayList[10];
        nextListArr[0] = new ArrayList<>(Arrays.asList(4, 6));
        nextListArr[1] = new ArrayList<>(Arrays.asList(6, 8));
        nextListArr[2] = new ArrayList<>(Arrays.asList(7, 9));
        nextListArr[3] = new ArrayList<>(Arrays.asList(4, 8));
        nextListArr[4] = new ArrayList<>(Arrays.asList(0, 3, 9));
        nextListArr[5] = new ArrayList<>();
        nextListArr[6] = new ArrayList<>(Arrays.asList(0, 1, 7));
        nextListArr[7] = new ArrayList<>(Arrays.asList(2, 6));
        nextListArr[8] = new ArrayList<>(Arrays.asList(1, 3));
        nextListArr[9] = new ArrayList<>(Arrays.asList(2, 4));

        long ans = 0;
        memo = new int[n+1][10];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i <= 9; i++) {
            ans = (ans + backTrack(n, i)) % MOD;
        }

        return (int) ans;
    }

}
