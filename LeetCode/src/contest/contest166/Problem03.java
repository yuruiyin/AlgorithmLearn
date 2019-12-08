package contest.contest166;

import java.util.Arrays;

public class Problem03 {

    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int len = nums.length;

        int low = 1;
        int high = nums[len - 1];

        while (low < high) {
            int mid = (low + high) >>> 1;
            int sum = 0;
            for (int num: nums) {
                sum += num / mid + (num % mid == 0 ? 0 : 1);
            }

            if (sum > threshold) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem03().smallestDivisor(new int[]{1,2,5,9}, 6));
        System.out.println(new Problem03().smallestDivisor(new int[]{2,3,5,7,11}, 11));
        System.out.println(new Problem03().smallestDivisor(new int[]{19}, 5));
    }
    
}
