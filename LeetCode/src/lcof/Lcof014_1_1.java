package lcof;

public class Lcof014_1_1 {

    private int[] memo;

    private int dp(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        int ansMax = 1;
        for (int i = 1; i <= n; i++) {
            ansMax = Math.max(ansMax, i * dp(n - i));
        }

        memo[n] = ansMax;
        return ansMax;
    }

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        memo = new int[n + 1];
        return dp(n);
    }

}
