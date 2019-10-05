package interview_microsoft.round01;

public class Problem03 {

    public int findMin(int[] nums) {
        // 二分
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return nums[left];
            }
            int mid = (left + right) >>> 1;
            if (nums[right] > nums[mid]) {
                // 最小值在左边区域
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Problem03().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Problem03().findMin(new int[]{4,5,6,7,0,1,2}));
    }

}
