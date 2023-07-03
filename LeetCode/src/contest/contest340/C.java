package contest.contest340;

import java.util.*;

public class C {

    public int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = (int) 1e9;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int count = 0;
            for (int i = 1; i < len; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    count++;
                    i++;
                }
            }
            if (count >= p) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
