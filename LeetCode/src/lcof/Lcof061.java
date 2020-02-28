package lcof;

import java.util.Arrays;

public class Lcof061 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                if (i > 0 && nums[i-1] != 0) {
                    if (nums[i] == nums[i-1]) {
                        return false;
                    }

                    if (nums[i] - nums[i-1] - 1 > zeroCount) {
                        return false;
                    }

                    zeroCount -= nums[i] - nums[i-1] - 1;
                }
            }
        }

        return true;
    }

}
