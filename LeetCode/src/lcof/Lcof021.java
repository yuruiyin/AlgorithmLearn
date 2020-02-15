package lcof;

public class Lcof021 {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int[] exchange(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }

            while (left < right && nums[right] % 2 == 0) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
            left++;
            right--;
        }

        return nums;
    }

}
