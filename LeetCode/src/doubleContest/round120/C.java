package doubleContest.round120;

public class C {

    private int findFirstBiggerOrEqual(int[] arr, int from, int target) {
        int low = from;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal > target) {
                if (mid == from || arr[mid - 1] <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public long incremovableSubarrayCount(int[] nums) {
        long ans = 1;
        int len = nums.length;
        int l = -1;
        int r = -1;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += i;
                l = i - 1;
                break;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                r = i + 1;
                ans += (len - i - 1);
                break;
            }
        }

        if (ans == 1) {
            // 整个数组严格递增
            return (long) len * (len + 1) / 2;
        }

        for (int i = 0; i <= l; i++) {
            int rightFirstGeqIdx = findFirstBiggerOrEqual(nums, r, nums[i]);
            if (rightFirstGeqIdx == -1) {
                break;
            }

            ans += (len - rightFirstGeqIdx);
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new C().incremovableSubarrayCount(new int[]{8, 7, 6, 6}));
        System.out.println(new C().incremovableSubarrayCount(new int[]{6,5,7,8}));
    }

}
