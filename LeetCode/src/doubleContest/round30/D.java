package doubleContest.round30;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/12
 */
public class D {

    private Boolean[] memo;

    private boolean rec(int n) {
        if (n == 0) {
            return false;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        boolean isWin = false;
        for (int i = 1; i * i <= n; i++) {
            if (!rec(n - i * i)) {
                isWin = true;
                break;
            }
        }

        memo[n] = isWin;
        return isWin;
    }

    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n + 1];
        return rec(n);
    }

}
