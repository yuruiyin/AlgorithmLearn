package contest.contest429;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B {

    public int maxDistinctElements(int[] nums, int k) {
        if (k == 0) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            return set.size();
        }

        Arrays.sort(nums);
        int len = nums.length;
        nums[0] -= k;
        nums[len - 1] += k;
        for (int i = 1; i < len - 1; i++) {
            nums[i] = Math.max(Math.min(nums[i] + k, nums[i - 1] + 1), nums[i] - k);
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size();
    }

}
