package problem201_300;

import java.util.Arrays;

public class Problem217_1 {

    // 先排序，然后遍历是否存在相邻元素相等的情况
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }

        return false;
    }

}
