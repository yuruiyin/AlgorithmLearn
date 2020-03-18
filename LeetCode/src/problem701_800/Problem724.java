package problem701_800;

/**
 * Problem724
 *
 * @author: yry
 * @date: 2020/3/16
 */
public class Problem724 {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum == sum - preSum - nums[i]) {
                return i;
            }
            preSum += nums[i];
        }

        return -1;
    }

}
