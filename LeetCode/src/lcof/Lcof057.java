package lcof;

public class Lcof057 {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int sum;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }

}
