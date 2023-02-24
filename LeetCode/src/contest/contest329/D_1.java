package contest.contest329;

import java.util.Arrays;

public class D_1 {

    private int len;

    private int[] memo;

    private int[] nums;

    private int k;

    private int dp(int curIdx) {
        if (curIdx == len) {
            return 0;
        }

        if (memo[curIdx] != -1) {
            return memo[curIdx];
        }

        int ansMin = Integer.MAX_VALUE;
        int pre = 0;
        int[] countArr = new int[len];
        for (int i = curIdx; i < len; i++) {
            countArr[nums[i]]++;
            int value = pre;
            if (countArr[nums[i]] == 2) {
                value += 2;
            } else if (countArr[nums[i]] > 2) {
                value++;
            }
//            ansMin = Math.min(ansMin, k + value + dp(i + 1));
            int cur = k + value + dp(i + 1);
            if (cur < ansMin) {
                ansMin = cur;
            }
            pre = value;
        }

        memo[curIdx] = ansMin;
        return ansMin;
    }

    public int minCost(int[] nums, int k) {
        this.len = nums.length;
        this.nums = nums;
        this.k = k;
        this.memo = new int[len];
        Arrays.fill(memo, -1);
        return dp(0);
    }

    public static void main(String[] args) {
//        [1,2,1,2,1,3,3], k = 2
        System.out.println(new D_1().minCost(new int[]{1,2,1,2,1,3,3}, 2));
    }

}
