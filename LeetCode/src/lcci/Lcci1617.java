package lcci;

/**
 * Lcci1617
 *
 * @author: yry
 * @date: 2020/4/10
 */
public class Lcci1617 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int preMax = nums[0];
        int ansMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(nums[i], preMax + nums[i]);
            ansMax = Math.max(ansMax, preMax);
        }
        return ansMax;
    }

}
