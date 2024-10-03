package contest.contest415;

public class B {

    private Long[][] dp;

    private int[] a;
    private int[] b;

    private long rec(int i, int j) {
        if (i == 4) {
            return 0;
        }

        if (b.length - j < 4 - i) {
            return Long.MIN_VALUE;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        long nonChooseRes = (long) -1e11;
        long nonTempRes = rec(i, j + 1);
        if (nonTempRes != Long.MIN_VALUE) {
            nonChooseRes = nonTempRes;
        }
        long chooseRes = (long) -1e11;;
        long res = rec(i + 1, j + 1);
        if (res != Long.MIN_VALUE) {
            chooseRes = (long)a[i] * b[j] + res;
        }

        return dp[i][j] = Math.max(nonChooseRes, chooseRes);
    }

    public long maxScore(int[] a, int[] b) {
        this.a = a;
        this.b = b;
        dp = new Long[4][b.length];

        return rec(0, 0);
    }

}
