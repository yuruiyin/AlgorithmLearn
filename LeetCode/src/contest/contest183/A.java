package contest.contest183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/5
 */
public class A {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        int curSum = 0;
        List<Integer> ansList = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            curSum += nums[i];
            ansList.add(nums[i]);
            if (curSum > sum - curSum) {
                return ansList;
            }
        }

        return null;
    }

}
