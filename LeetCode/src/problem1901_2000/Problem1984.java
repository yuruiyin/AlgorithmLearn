package problem1901_2000;

import java.util.Arrays;
import java.util.Map;

public class Problem1984 {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i < len - k + 1; i++) {
            ansMin = Math.min(ansMin, nums[i + k - 1] - nums[i]);
        }
        return ansMin;
    }

}
