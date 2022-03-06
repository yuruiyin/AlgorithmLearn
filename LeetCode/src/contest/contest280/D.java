package contest.contest280;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2022/2/13
 */
public class D {

    private int[] nums;
    private int len;
    private int[][] memo;
    private int numSlots;

    private int convert(int[] slotStatus) {
        int ans = 0;
        for (int i = 0; i < numSlots; i++) {
            ans <<= 2;
            ans += slotStatus[i];
        }
        return ans;
    }

    private int dp(int numIdx, int[] slotStatus) {
        if (numIdx == len) {
            return 0;
        }

        int slotValue = convert(slotStatus);
        if (memo[numIdx][slotValue] != -1) {
            return memo[numIdx][slotValue];
        }

        int ansMax = 0;
        for (int i = 0; i < numSlots; i++) {
            if (slotStatus[i] < 2) {
                slotStatus[i]++;
                int value = (nums[numIdx] & (i + 1)) + dp(numIdx + 1, slotStatus);
                slotStatus[i]--;
                ansMax = Math.max(ansMax, value);
            }
        }

        memo[numIdx][slotValue] = ansMax;
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
        int[] slotStatus = new int[numSlots];
        return dp(0, slotStatus);
    }

    public static void main(String[] args) {
        System.out.println(new D().maximumANDSum(new int[]{1, 2, 3, 4, 5, 6}, 3));
    }

}
