package lcof;

public class Lcof053_1 {

    private int findFirstEqualIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    if (nums[mid] != target) {
                        return -1;
                    }
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int findLastEqualIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal <= target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    if (nums[mid] != target) {
                        return -1;
                    }
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int firstEqualIndex = findFirstEqualIndex(nums, target);
        if (firstEqualIndex == -1) {
            return 0;
        }

        int lastEqualIndex = findLastEqualIndex(nums, target);

        return lastEqualIndex - firstEqualIndex + 1;
    }

}
