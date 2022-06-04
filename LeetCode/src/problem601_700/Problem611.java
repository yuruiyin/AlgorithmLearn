package problem601_700;

import java.util.Arrays;

public class Problem611 {

    private int findLastSmallerIdx(int[] arr, int from, int target) {
        int len = arr.length;
        int l = from;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) {
                if (mid == len - 1 || arr[mid + 1] >= target) {
                    return mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        // 最小两边之和大于第三边
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int sum = nums[i] + nums[j];
                if (sum == 0) {
                    continue;
                }
                int lastSmallerIdx = findLastSmallerIdx(nums, j + 1, nums[i] + nums[j]);
                if (lastSmallerIdx != -1) {
                    ans += lastSmallerIdx - j;
                }
            }
        }
        return ans;
    }

}
