package doubleContest.round120;

import java.util.Arrays;

public class B {

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long preSum = nums[0] + nums[1];
        int len = nums.length;
        long ansMax = -1;
        for (int i = 2; i < len; i++) {
            if (nums[i] < preSum) {
                preSum += nums[i];
                ansMax = Math.max(ansMax, preSum);
            } else {
                preSum += nums[i];
            }
        }
        return ansMax;
    }

}
