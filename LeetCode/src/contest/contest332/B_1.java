package contest.contest332;

import java.util.Arrays;

public class B_1 {

    private int findLastSmallerOrEqual(int[] arr, int from, int to, int target) {
        int low = from;
        int high = to;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal <= target) {
                if (mid == to || arr[mid + 1] > target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int findLastSmaller(int[] arr, int from, int to, int target) {
        int low = from;
        int high = to;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal < target) {
                if (mid == to || arr[mid + 1] >= target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        int len = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        int l = -1;
        int r = -1;
        for (int i = 1; i < len; i++) {
            int left = lower - nums[i];
            int right = upper - nums[i];
            int rightIdx = findLastSmallerOrEqual(nums, 0, i - 1, right);
            if (rightIdx == -1) {
                continue;
            }
            int leftIdx = findLastSmaller(nums, 0, i - 1, left);
            if (leftIdx == -1) {
                ans += rightIdx + 1;
                continue;
            }
            ans += (rightIdx - leftIdx);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new B_1().countFairPairs(new int[]{0,1,7,4,4,5}, 3, 6));

        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(arr[5]);
        
        System.out.println(1);
    }

}
