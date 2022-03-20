package contest.contest285;

import java.util.Arrays;

public class C {

    private int[] aliceArrows;
    private int[][] memo;
    private int maxScore;
    private int[] bobArrows;

    private int dp(int idx, int bobNumArrows) {
        if (idx == -1) {
            return 0;
        }

        if (bobNumArrows <= 0) {
            return 0;
        }

        if (memo[idx][bobNumArrows] != -1) {
            return memo[idx][bobNumArrows];
        }

        if (bobNumArrows <= aliceArrows[idx]) {
            return dp(idx - 1, bobNumArrows);
        }

        int chooseRes = idx + dp(idx - 1, bobNumArrows - aliceArrows[idx] - 1);
        int nonChooseRes = dp(idx - 1, bobNumArrows);
        memo[idx][bobNumArrows] = Math.max(chooseRes, nonChooseRes);
        return memo[idx][bobNumArrows];
    }

    private int getScore(int[] bobArrows) {
        int ans = 0;
        for (int i = 0; i < 12; i++) {
            if (bobArrows[i] > aliceArrows[i]) {
                ans += i;
            }
        }
        return ans;
    }

    private int dp1(int idx, int bobNumArrows, int[] tmpBobArrows) {
        if (idx == -1 || bobNumArrows <= 0) {
            if (getScore(tmpBobArrows) == maxScore) {
                bobArrows = Arrays.copyOf(tmpBobArrows, 12);
            }
            return 0;
        }

        if (bobNumArrows <= aliceArrows[idx]) {
            return dp1(idx - 1, bobNumArrows, tmpBobArrows);
        }

        tmpBobArrows[idx] = aliceArrows[idx] + 1;
        int chooseRes = idx + dp1(idx - 1, bobNumArrows - aliceArrows[idx] - 1, tmpBobArrows);
        tmpBobArrows[idx] = 0;
        int nonChooseRes = dp1(idx - 1, bobNumArrows, tmpBobArrows);
        return Math.max(chooseRes, nonChooseRes);
    }

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        this.aliceArrows = aliceArrows;
        memo = new int[12][numArrows + 1];
        for (int i = 0; i < 12; i++) {
            Arrays.fill(memo[i], -1);
        }

        maxScore = dp(11, numArrows);
        bobArrows = new int[12];
        dp1(11, numArrows, new int[12]);
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += bobArrows[i];
        }

        if (sum < numArrows) {
            bobArrows[0] += numArrows - sum;
        }

        return bobArrows;
    }

    public static void main(String[] args) {
        int[] ansArr = new C().maximumBobPoints(9, new int[]{1,1,0,1,0,0,2,1,0,1,2,0});
        for (int num : ansArr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
