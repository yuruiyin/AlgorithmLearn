package interview_bytedance.round08;

public class Problem01 {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int midValue = nums[mid];

            if (midValue == target) {
                return mid;
            } else if (target < midValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem01().searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(new Problem01().searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(new Problem01().searchInsert(new int[]{1,3,5,6}, 7));
    }
    
}
