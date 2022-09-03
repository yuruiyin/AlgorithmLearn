package problem701_800;

import java.util.Arrays;

public class Problem719_1 {

    private boolean isOk(int[] nums, int max, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0, j = 1; i < len; i++) {
            while (j < len && nums[j] - nums[i] <= max) {
                j++;
            }
            count += j - i - 1;
        }
        return count >= k;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        // 二分
        int l = 0;
        int r = 1000000;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (isOk(nums, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

}
