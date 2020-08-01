package contest.contest192;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/7
 */
public class D {

    private final static int MAX = (int) 1e9;

    private int[] houses;
    private int[][] costArr;
    private int houseCount;
    private int colorCount;
    private int[][][] memo;

    private int dp(int preColor, int target, int idx) {
        if (idx == houseCount) {
            return target == 0 ? 0 : MAX;
        }

        if (memo[preColor][target][idx] != -1) {
            return memo[preColor][target][idx];
        }

        if (target == 0) {
            boolean isOk = true;
            int cost = 0;
            for (int i = idx; i < houseCount; i++) {
                if (houses[i] != 0 && houses[i] != preColor) {
                    isOk = false;
                    break;
                }

                if (houses[i] == 0) {
                    cost += costArr[i][preColor - 1];
                }
            }

            if (!isOk) {
                memo[preColor][target][idx] = MAX;
                return MAX;
            }

            memo[preColor][target][idx] = cost;
            return cost;
        }

        if (houseCount - idx < target) {
            memo[preColor][target][idx] = MAX;
            return memo[preColor][target][idx];
        }

        if (houses[idx] != 0) {
            memo[preColor][target][idx] = dp(houses[idx], houses[idx] == preColor ? target : target - 1, idx + 1);
            return memo[preColor][target][idx];
        }

        int res = Integer.MAX_VALUE;
        for (int curColor = 1; curColor <= colorCount; curColor++) {
            int tmpRes;
            if (curColor == preColor) {
                tmpRes = dp(curColor, target, idx + 1) + costArr[idx][curColor - 1];
            } else {
                tmpRes = dp(curColor, target - 1, idx + 1) + costArr[idx][curColor - 1];
            }
            res = Math.min(res, tmpRes);
        }

        memo[preColor][target][idx] = res;
        return memo[preColor][target][idx];
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.costArr = cost;
        this.houseCount = m;
        this.colorCount = n;

        memo = new int[n + 1][target + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        int ans = dp(0, target, 0);
        if (ans >= MAX) {
            return -1;
        }

        return ans;
    }

}
