package contest.contest334;

import java.util.Arrays;

public class C_2 {

    private int findFirstBiggerOrEqual(int[] arr, int from, int target) {
        int low = from;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal >= target) {
                if (mid == from || arr[mid - 1] < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int fromIdx = len / 2;
        int ans = 0;
        int endIdx = len >> 1;
        for (int i = 0; i < endIdx; i++) {
            int next = nums[i] << 1;
            int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(nums, fromIdx, next);
            if (firstBiggerOrEqualIdx == -1) {
                break;
            }
            ans += 2;
            fromIdx = firstBiggerOrEqualIdx + 1;
        }
        return ans;
    }

}
