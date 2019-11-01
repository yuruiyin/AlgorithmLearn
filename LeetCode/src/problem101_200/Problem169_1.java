package problem101_200;

import java.util.Arrays;

public class Problem169_1 {

    /**
     * 先排序，然后返回中间的那个数就是众数
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    public static void main(String[] args) {

    }
    
}
