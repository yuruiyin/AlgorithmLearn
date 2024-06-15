package problem2701_2800;

import java.util.Arrays;

public class Problem2779_3 {

    private static final int[] endQueue = new int[100000];

    public int maximumBeauty(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }

        Arrays.sort(nums);
        int maxCount = 0;
        endQueue[0] = nums[0] + k;
        int start = 0;
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] - k > endQueue[start]) {
                start++;
            }
            endQueue[++end] = nums[i] + k;
            maxCount = Math.max(maxCount, end - start + 1);
        }
        return maxCount;
    }

}
