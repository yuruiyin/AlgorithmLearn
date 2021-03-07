package doubleContest.round47;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/7
 */
public class B {

    private Boolean[] memo;

    private boolean rec(int n, boolean[] visited) {
        if (n == 0) {
            return true;
        }

        if (n == 1) {
            return !visited[0];
        }

        if (memo[n] != null) {
            return memo[n];
        }

        for (int i = 0; i <= 15; i++) {
            if (visited[i]) {
                continue;
            }

            int pow = (int) Math.pow(3, i);
            if (pow > n) {
                break;
            }

            visited[i] = true;

            if (rec(n - pow, visited)) {
                visited[i] = false;
                memo[n] = true;
                return true;
            }

            visited[i] = false;
        }

        memo[n] = false;
        return false;
    }

    public boolean checkPowersOfThree(int n) {
        memo = new Boolean[n + 1];
        return rec(n, new boolean[16]);
    }

}
