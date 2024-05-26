package contest.contest376;

import java.util.Arrays;

public class B {

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int[][] ans = new int[len / 3][3];
        for (int i = 0; i < len; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[][]{};
            }
            ans[i / 3][0] = nums[i];
            ans[i / 3][1] = nums[i + 1];
            ans[i / 3][2] = nums[i + 2];
        }
        return ans;
    }

}
