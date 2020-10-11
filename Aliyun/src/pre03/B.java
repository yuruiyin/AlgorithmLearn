package pre03;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/5
 */
public class B {

    private static final int MAX = 1000000000;

    private Integer[][][][] memo;
    private int[][] minCostColorArr;
    private int[][] costs;
    private int n;
    private int colorCount;
    private int t;

    private int dp(int curRow, int preRowColorIdx, int intervalCount, int hasInterval) {
        if (intervalCount > t) {
            return MAX;
        }

        if (curRow == n) {
            return 0;
        }

        if (memo[curRow][preRowColorIdx][intervalCount][hasInterval] != null) {
            return memo[curRow][preRowColorIdx][intervalCount][hasInterval];
        }

        int preRowColor = minCostColorArr[curRow - 1][preRowColorIdx];
        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int curRowColor = minCostColorArr[curRow][i];
            if (intervalCount == 1 && hasInterval == 1 && curRowColor == preRowColor) {
                continue;
            }

            int nextIntervalCount = curRowColor == preRowColor ? (intervalCount + 1) : 1;
            int res = dp(curRow + 1, i, nextIntervalCount, hasInterval == 1 || (nextIntervalCount > 1) ? 1 : 0) +
                    costs[curRow][curRowColor];
            ansMin = Math.min(ansMin, res);
        }

        memo[curRow][preRowColorIdx][intervalCount][hasInterval] = ansMin;
        return ansMin;
    }

    /**
     * @param costs: costs of paint ith house into color j
     * @param t: maximum length of street
     * @return: minimum costs of painting all houses
     */
    public int paintHouseIII(int[][] costs, int t) {
        // Write your code here.
        // 每行选择最小费用的两个就可以
        this.n = costs.length;
        this.colorCount = costs[0].length;
        minCostColorArr = new int[n][2];
        this.costs = costs;
        this.t = t;

        if (colorCount == 1) {
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += costs[i][0];
            }

            return ans;
        }

        for (int i = 0; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            int minCostColor = -1;
            for (int j = 0; j < colorCount; j++) {
                if (costs[i][j] < minCost) {
                    minCost = costs[i][j];
                    minCostColor = j;
                }
            }

            minCostColorArr[i][0] = minCostColor;
            int secondMinCost = Integer.MAX_VALUE;
            int secondMinCostColor = -1;
            for (int j = 0; j < colorCount; j++) {
                if (costs[i][j] < secondMinCost && j != minCostColor) {
                    secondMinCost = costs[i][j];
                    secondMinCostColor = j;
                }
            }

            minCostColorArr[i][1] = secondMinCostColor;
        }


        memo = new Integer[n + 1][2][t + 1][2];

        return Math.min(dp(1, 0, 1, 0) + costs[0][minCostColorArr[0][0]] ,
                dp(1, 1, 1, 0) + costs[0][minCostColorArr[0][1]] );
    }

    public static void main(String[] args) {
        System.out.println(new B().paintHouseIII(new int[][]{
                {1},
                {2}
        }, 2));
    }

}
