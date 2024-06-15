package problem2701_2800;

import java.util.Arrays;

public class Problem2779_4 {

    public int maximumBeauty(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }

        Arrays.sort(nums);
        int maxCount = 0;
        int l = 0;
        int r = 0;
        while (r < len) {
            if (nums[r] - k > nums[l] + k) {
                l++;
            } else {
                r++;
            }
            maxCount = Math.max(maxCount, r - l);
        }
        return maxCount;
    }

}
