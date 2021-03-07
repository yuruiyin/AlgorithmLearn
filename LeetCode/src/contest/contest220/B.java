package contest.contest220;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/20
 */
public class B {

    public int maximumUniqueSubarray(int[] nums) {
        int[] indexArr = new int[10001];
        Arrays.fill(indexArr, -1);
        int len = nums.length;
        int preLeftIdx = 0;
        int ansMax = nums[0];
        indexArr[nums[0]] = 0;
        int preSum = nums[0];

        int[] preSumArr = new int[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        for (int i = 1; i < len; i++) {
            int preIdx = indexArr[nums[i]];
            indexArr[nums[i]] = i;

            if (preIdx == -1 || preIdx < preLeftIdx) {
                preSum += nums[i];
            } else {
                preSum = preSum - (preSumArr[preIdx] - (preLeftIdx == 0 ? 0 : preSumArr[preLeftIdx - 1])) + nums[i];
                preLeftIdx = preIdx + 1;
            }
            ansMax = Math.max(ansMax, preSum);
        }

        return ansMax;
    }

}
