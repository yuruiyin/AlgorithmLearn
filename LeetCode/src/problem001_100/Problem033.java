package problem001_100;

public class Problem033 {

    private int commonBinarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int len = nums.length;

        if (len <= 0) {
            return -1;
        }

        int endValue = nums[len - 1];
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            if (nums[low] < nums[high]) {
                return commonBinarySearch(nums, low, high, target);
            }
            int mid = (low + high) >>> 1;
            int midValue = nums[mid];
            if (target == midValue) {
                return mid;
            } else if (target < midValue) {
                if (midValue > endValue) {
                    // 说明分界点在右侧，mid左侧是有序的
                    if (target <= endValue) {
                        // 在右侧
                        low = mid + 1;
                    } else {
                        return commonBinarySearch(nums, low, mid - 1, target);
                    }
                } else {
                    // 说明mid左侧无序，右侧有序，但是target < midValue，因此值再无序额左侧
                    high = mid - 1;
                }
            } else {
                if (midValue > endValue) {
                    // 说明分界点在右侧，mid左侧是有序的
                    low = mid + 1;
                } else {
                    if (target <= endValue) {
                        return commonBinarySearch(nums, mid + 1, high, target);
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem033().search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(new Problem033().search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(new Problem033().search(new int[]{4}, 4));
        System.out.println(new Problem033().search(new int[]{4}, 3));
        System.out.println(new Problem033().search(new int[]{}, 3));
    }

}
