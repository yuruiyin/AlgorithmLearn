package contest.contest296;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {

    public int partitionArray(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int max = nums[len - 1];
        int ans = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (max - nums[i] > k) {
                ans++;
                max = nums[i];
            }
        }
        return ans;
    }

}
