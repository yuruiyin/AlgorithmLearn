package problem201_300;

import java.util.Arrays;

public class Problem287_1 {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }

}
