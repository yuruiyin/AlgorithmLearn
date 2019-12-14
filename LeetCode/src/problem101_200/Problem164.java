package problem101_200;

import java.util.Arrays;

public class Problem164 {

    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int max = 0;

        for (int i = 0; i < len - 1; i++) {
            int diff = nums[i+1] - nums[i];
            if (diff > max) {
                max = diff;
            }
        }

        return max;
    }

}
