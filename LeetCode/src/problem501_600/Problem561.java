package problem501_600;

import java.util.Arrays;

/**
 * Problem561
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class Problem561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i+=2) {
            ans += nums[i];
        }
        return ans;
    }

}
