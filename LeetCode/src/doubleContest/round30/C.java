package doubleContest.round30;

import java.util.Arrays;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/12
 */
public class C {

    public int minDifference(int[] nums) {
        int len = nums.length;
        if (len <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int count = len - 3;
        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i <= len - count; i++) {
            ansMin = Math.min(ansMin, nums[i + count - 1] - nums[i]);
        }

        return ansMin;
    }

}
