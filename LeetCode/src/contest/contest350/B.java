package contest.contest350;

import java.util.Arrays;

public class B {

    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ansMin = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff < ansMin) {
                ansMin = diff;
            }
        }
        return ansMin;
    }

}
