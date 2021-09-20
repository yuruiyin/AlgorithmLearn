package contest.contest254;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/15
 */
public class B {

    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < len - 1; i+=2) {
            int t = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = t;
        }
        return nums;
    }

}
