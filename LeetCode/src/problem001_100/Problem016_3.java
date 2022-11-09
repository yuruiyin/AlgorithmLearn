package problem001_100;

import java.util.Arrays;

public class Problem016_3 {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int ansSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = len - 1; i >= 2; i--) {
            int r = i - 1;
            int l = 0;
            while (l < r) {
                int maxSum = nums[i] + nums[r] + nums[r - 1];
                if (maxSum <= target) {
                    // 如果当前最大sum都小于等于target，那么继续遍历diff必然会变大，因此直接break
                    if (target - maxSum < Math.abs(target - ansSum)) {
                        ansSum = maxSum;
                    }
                    break;
                }

                int minSum = nums[i] + nums[l] + nums[l + 1];
                if (minSum >= target) {
                    // 如果当前最小sum都大于等于target，那么继续遍历肯定diff必然会变大，因此直接break
                    if (minSum - target < Math.abs(target - ansSum)) {
                        ansSum = minSum;
                    }
                    break;
                }

                int sum = nums[i] + nums[l] + nums[r];
                int diff;
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    diff = sum - target;
                    r--;
                } else {
                    diff = target - sum;
                    l++;
                }
                if (diff < Math.abs(target - ansSum)) {
                    ansSum = sum;
                }
            }
        }
        return ansSum;
    }



}
