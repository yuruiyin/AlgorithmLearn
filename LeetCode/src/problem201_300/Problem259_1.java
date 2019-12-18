package problem201_300;

import java.util.Arrays;

public class Problem259_1 {

    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            int needTwoSum = target - nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < needTwoSum) {
                    ans += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }

}
