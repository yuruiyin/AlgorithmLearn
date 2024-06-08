package problem3001_3100;

import java.util.*;

public class Problem3040_1 {

    private int[] nums;
    private int len;

    private int[][] memo;

    // 是否已经是最优解了
    private boolean done = false;

    private int rec(int l, int idx, int score) {
        if (done) {
            return 0;
        }

        int r = len - 2 * idx + l - 1;
        if (l >= r) {
            done = true;
            return 0;
        }
        if (l >= len || r < 0) {
            return 0;
        }

        if (memo[l][idx] != -1) {
            return memo[l][idx];
        }

        int res = 0;
        if (nums[l] + nums[l + 1] == score) {
            res = 1 + rec(l + 2, idx + 1, score);
        }

        if (nums[l] + nums[r] == score) {
            res = Math.max(res, 1 + rec(l + 1, idx + 1, score));
        }

        if (nums[r] + nums[r - 1] == score) {
            res = Math.max(res, 1 + rec(l, idx + 1, score));
        }

        return memo[l][idx] = res;
    }

    public int maxOperations(int[] nums) {
        // 分数只有三种选择，同时这三种选择也可能存在相同的
        // 1. nums[0] + nums[1]
        // 2. nums[len - 2] + nums[len - 1]
        // 3. nums[0] + nums[len - 1]
        this.len = nums.length;
        this.nums = nums;
        Set<Integer> scoreSet = new HashSet<>();
        scoreSet.add(nums[0] + nums[1]);
        scoreSet.add(nums[len - 2] + nums[len - 1]);
        scoreSet.add(nums[0] + nums[len - 1]);
        // set 转 arr
        int memoLen = len;
        memo = new int[memoLen][memoLen / 2];
        int ansMax = 0;
        for (int score: scoreSet) {
            for (int i = 0; i < memoLen; i++) {
                Arrays.fill(memo[i], -1);
            }
            ansMax = Math.max(ansMax, rec(0, 0, score));
        }
        return ansMax;
    }

}
