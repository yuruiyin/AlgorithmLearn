package contest.contest344;

import java.util.Arrays;

public class D {

    private int[] memo;
    private int max;

    private int ans = 0;

    private int getMax(int curIdx, int[] cost) {
        int left = curIdx * 2 + 1;
        if (left >= cost.length) {
            // 叶子
            return memo[curIdx] = cost[curIdx];
        }

        int right = curIdx * 2 + 2;
        int curCost = cost[curIdx];
        int leftRes = getMax(left, cost);
        int rightRes = getMax(right, cost);
        return memo[curIdx] = curCost + Math.max(leftRes, rightRes);
    }

    private void rec(int curIdx, int tmpSum, int[] cost) {
        int left = curIdx * 2 + 1;
        if (left >= cost.length) {
            // 叶子
            ans += max - (tmpSum + cost[curIdx]);
            return;
        }

        int right = curIdx * 2 + 2;
        if (tmpSum + memo[curIdx] < max) {
            int diff = max - (tmpSum + memo[curIdx]);
            ans += diff;
            tmpSum += diff;
        }

        rec(left, tmpSum + cost[curIdx], cost);
        rec(right, tmpSum + cost[curIdx], cost);
    }

    public int minIncrements(int n, int[] cost) {
        // 先求最大的路径
        memo = new int[n];
        Arrays.fill(memo, -1);
        max = getMax(0, cost);
        rec(0, 0, cost);
        return ans;
    }

}
