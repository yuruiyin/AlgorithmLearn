public class Problem034 {

    private int findFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midValue = nums[mid];
            if (target < midValue) {
                high = mid - 1;
            } else if (target > midValue) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != midValue) {
                    return mid;
                }

                high = mid - 1;
            }
        }

        return -1;
    }

    private int findEndIndex(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midValue = nums[mid];
            if (target < midValue) {
                high = mid - 1;
            } else if (target > midValue) {
                low = mid + 1;
            } else {
                if (mid == len - 1 || nums[mid + 1] != midValue) {
                    return mid;
                }

                low = mid + 1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int firstIndex = findFirstIndex(nums, target);

        if (firstIndex == -1) {
            return new int[]{-1, -1};
        }

        int endIndex = findEndIndex(nums, target);

        return new int[]{firstIndex, endIndex};
    }
    
    public static void main(String[] args) {
        int[] resArr = new Problem034().searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(resArr[0] + "," + resArr[1]);
        int[] resArr1 = new Problem034().searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(resArr1[0] + "," + resArr1[1]);
    }

}
