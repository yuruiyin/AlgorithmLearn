package doubleContest.round53;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/29
 */
public class B {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ansMin = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            ansMin = Math.max(ansMin, nums[l] + nums[r]);
            l++;
            r--;
        }
        return ansMin;
    }

}
