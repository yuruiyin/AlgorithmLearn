package contest.contest334;

import java.util.Arrays;

public class C_1 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = 0;
        int lEndIdx = len / 2;
        for (int l = 0, r = len / 2; l < lEndIdx && r < len; l++) {
            int right = nums[l] << 1;
            while (r < len) {
                if (nums[r] >= right) {
                    ans += 2;
                    r++;
                    break;
                }
                r++;
            }
        }
        return ans;
    }

}
