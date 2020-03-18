package lcci;

import java.util.Arrays;

/**
 * Lcci1011
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class Lcci1011 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 1; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
        }
    }

}
