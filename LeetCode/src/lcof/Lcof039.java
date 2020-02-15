package lcof;

import java.util.Arrays;

public class Lcof039 {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len / 2];
    }

}
