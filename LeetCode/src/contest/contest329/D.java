package contest.contest329;

import java.util.Arrays;

public class D {

    private int len;

    private int[][] interval;

    private int[] nums;

    private int dp(int curIdx, int k, int[] nums, int[] memo) {
        if (curIdx == len) {
            return 0;
        }

        if (memo[curIdx] != -1) {
            return memo[curIdx];
        }

        int ansMin = Integer.MAX_VALUE;
        for (int i = curIdx; i < len; i++) {
            int value = interval[curIdx][i];
            ansMin = Math.min(ansMin, k + value + dp(i + 1, k, nums, memo));
        }

        memo[curIdx] = ansMin;
        return ansMin;
    }

    private void calcInterval() {
        interval = new int[len][len];
        for (int i = 0; i < len; i++) {
            int[] countArr = new int[len];
            for (int j = i; j < len; j++) {
                countArr[nums[j]]++;
                if (countArr[nums[j]] == 2) {
                    interval[i][j] = (j == i ? 0 : interval[i][j - 1]) + 2;
                } else if (countArr[nums[j]] > 2) {
                    interval[i][j] = (j == i ? 0 : interval[i][j - 1]) + 1;
                } else {
                    interval[i][j] = j == i ? 0 : interval[i][j - 1];
                }
            }
        }
    }

    public int minCost(int[] nums, int k) {
        this.nums = nums;
        this.len = nums.length;
        calcInterval();
        int[] memo = new int[len];
        Arrays.fill(memo, -1);
        return dp(0, k, nums, memo);
    }

    public static void main(String[] args) {
//        [1,2,1,2,1,3,3], k = 2
        System.out.println(new D().minCost(new int[]{1,2,1,2,1,3,3}, 2));
    }

}
