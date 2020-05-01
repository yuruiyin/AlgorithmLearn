package problem401_500;

import java.util.Arrays;

/**
 * Problem453
 *
 * @author: yry
 * @date: 2020/4/15
 */
public class Problem453 {

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        // n - 1个数都加1，比如是最小的数都加1，那么相当于最大的数减1
        int len = nums.length;
        int target = nums[0];
        int ans = 0;
        for (int i = len - 1; i >= 1; i--) {
            ans += nums[i] - target;
        }
        return ans;
    }

}
