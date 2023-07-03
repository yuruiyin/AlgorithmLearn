package problem901_1000;

import java.util.Arrays;

public class Problem1000_1 {

    private int k;
    private int[][] memo;
    private int[] preSumArr;

    private int dfs(int l, int r) {
        if (l == r) {
            return 0;
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int ansMin = Integer.MAX_VALUE;
        for (int i = l; i < r; i += k - 1) {
            ansMin = Math.min(ansMin, dfs(l, i) + dfs(i + 1, r));
        }

        if ((r - l) % (k - 1) == 0) {
            // 可以合并成一堆
            ansMin += preSumArr[r + 1] - preSumArr[l];
        }

        return memo[l][r] = ansMin;
    }

    public int mergeStones(int[] stones, int k) {
        if (stones.length == 1) {
            return 0;
        }

        int len = stones.length;
        if ((len - 1) % (k - 1) != 0) {
            return -1;
        }

        preSumArr = new int[len + 1];
        preSumArr[1] = stones[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i + 1] = preSumArr[i] + stones[i];
        }

        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        this.k = k;

        return dfs(0, len - 1);
    }

}
