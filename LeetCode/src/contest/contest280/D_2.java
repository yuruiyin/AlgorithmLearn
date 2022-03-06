package contest.contest280;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2022/2/13
 */
public class D_2 {

    private int[] nums;
    private int len;
    private int[][] memo;
    private int numSlots;

    private int dp(int numIdx, int slotStatus) {
        if (numIdx == len) {
            return 0;
        }

        if (memo[numIdx][slotStatus] != -1) {
            return memo[numIdx][slotStatus];
        }

        int ansMax = 0;
        for (int i = 0; i < numSlots; i++) {
            if ((slotStatus & (3 << (i << 1))) < (2 << (i << 1))) {
                int value = (nums[numIdx] & (i + 1)) + dp(numIdx + 1, slotStatus + (1 << (i << 1)));
                ansMax = Math.max(ansMax, value);
            }
        }

        memo[numIdx][slotStatus] = ansMax;
        return ansMax;
    }

    public int maximumANDSum(int[] nums, int numSlots) {
        this.nums = nums;
        this.len = nums.length;
        this.numSlots = numSlots;
        Arrays.sort(nums);
        memo = new int[len][1 << (numSlots * 2)];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new D_2().maximumANDSum(new int[]{1, 2, 3, 4, 5, 6}, 3));
    }

}
