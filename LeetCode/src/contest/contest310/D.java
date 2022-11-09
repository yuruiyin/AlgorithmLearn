package contest.contest310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class D {

    private int[][] memo;

    private int[] nums;
    private int k;
    private int len;

    private int dp(int curIdx, int choose) {
        if (curIdx == len) {
            return 0;
        }

        if (memo[choose][curIdx] != -1) {
            return memo[choose][curIdx];
        }

        int ansMax = 0;
        if (choose == 0) {
            ansMax = Math.max(dp(curIdx + 1, 0), dp(curIdx + 1, 1));
        } else {
            ansMax = 1;
            for (int j = curIdx + 1; j < len; j++) {
                if (nums[j] > nums[curIdx] && nums[j] <= nums[curIdx] + k) {
                    ansMax = Math.max(ansMax, dp(j, 1) + 1);
                }
            }
        }

        memo[choose][curIdx] = ansMax;
        return ansMax;
    }

    public int lengthOfLIS(int[] nums, int k) {
        this.len = nums.length;
        memo = new int[2][len];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(memo[i], -1);
        }
        this.nums = nums;
        this.k = k;
        return Math.max(dp(0, 0), dp(0, 1));
    }

}
