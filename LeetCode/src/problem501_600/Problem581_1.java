package problem501_600;

public class Problem581_1 {

    private int binarySearchFirstBigger(int[] nums, int from, int to, int target) {
        int low = from;
        int high = to;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal > target) {
                if (mid == from || nums[mid-1] <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchLastSmaller(int[] nums, int from, int to, int target) {
        int low = from;
        int high = to;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target) {
                if (mid == to || nums[mid+1] >= target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // 从左往右找到第一次降序的，从右往左找到第一次升序的，然后确定要了要升序的区间
    // 接着，求该区间的最小值和最大值，通过二分的方法找到最小值在左侧升序区间的位置和最大值在右侧升序区间的位置即可
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = -1;
        int right = -1;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i+1]) {
                left = i;
                break;
            }
        }

        if (left == -1) {
            // 原数组已经是升序的
            return 0;
        }

        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] < nums[i-1]) {
                right = i;
                break;
            }
        }

        // 计算[left, right]区间的最小和最大值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int ansLeft = left;
        if (left > 0) {
            int leftIndex = binarySearchFirstBigger(nums, 0, left-1, min);
            if (leftIndex != -1) {
                ansLeft = leftIndex;
            }
        }

        int ansRight = right;
        if (right < len - 1) {
            int rightIndex = binarySearchLastSmaller(nums, right + 1, len - 1, max);
            if (rightIndex != -1) {
                // 后面全部都比max小
                ansRight = rightIndex;
            }
        }

        return ansRight - ansLeft + 1;

    }

}
