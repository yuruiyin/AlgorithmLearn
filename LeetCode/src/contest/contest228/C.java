package contest.contest228;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/14
 */
public class C {

    private boolean isOk(int[] nums, int maxOperations, int max) {
        int count = 0;
        for (int num : nums) {
            if (num <= max) {
                continue;
            }

            count += num / max - 1 + (num % max == 0 ? 0 : 1);
        }

        return count <= maxOperations;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int len = nums.length;

        int l = 1;
        int r = 1000000000;
        int ans = r;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(nums, maxOperations, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
