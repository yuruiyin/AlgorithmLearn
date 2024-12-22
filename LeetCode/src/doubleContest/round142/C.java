package doubleContest.round142;

public class C {

    private Integer[][] dp;

    private int n;

    private int k;

    private int[][] stayScore;

    private int[][] travelScore;

    private int rec(int curCity, int curDay) {
        if (curDay == k) {
            return 0;
        }

        if (dp[curCity][curDay] != null) {
            return dp[curCity][curDay];
        }

        int stayRes = stayScore[curDay][curCity] + rec(curCity, curDay + 1);
        int nextRes = 0;
        for (int nextCity = 0; nextCity < n; nextCity++) {
            if (nextCity == curCity) {
                continue;
            }

            nextRes = Math.max(nextRes, travelScore[curCity][nextCity] + rec(nextCity, curDay + 1));
        }

        return dp[curCity][curDay] = Math.max(stayRes, nextRes);
    }

    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        this.n = n;
        this.k = k;
        this.stayScore = stayScore;
        this.travelScore = travelScore;

        dp = new Integer[n][k];
        int ansMax = 0;
        for (int i = 0; i < n; i++) {
            int tmpRes = rec(i, 0);
            ansMax = Math.max(ansMax, tmpRes);
        }
        return ansMax;
    }

}
