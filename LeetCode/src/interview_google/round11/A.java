package interview_google.round11;

import java.util.Arrays;

public class A {

    private int[][] memo;

    private int dp(int curCount, int copyCount, int targetCount) {
        if (curCount == targetCount) {
            return 0;
        }
        if (curCount > targetCount) {
            return -1;
        }
        if (memo[curCount][copyCount] != -1) {
            return memo[curCount][copyCount];
        }

        int res = Integer.MAX_VALUE;
        int res1 = dp(curCount + copyCount, copyCount, targetCount);
        if (res1 != -1) {
            res = res1 + 1;
        }
        int res2 = dp(curCount << 1, curCount, targetCount);
        if (res2 != -1) {
            res = Math.min(res, res2 + 2);
        }
        memo[curCount][copyCount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[curCount][copyCount];
    }

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        memo = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(2, 1, n) + 2;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
