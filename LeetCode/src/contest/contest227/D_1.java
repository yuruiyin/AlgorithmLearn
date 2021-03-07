package contest.contest227;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/10
 */
public class D_1 {

    private int[] nums;
    private int len;
    private Map<Long, Integer> memoMap;
    private int goal;

    private int rec(int from, int target) {
        if (target > Math.abs(goal)) {
            return Integer.MAX_VALUE;
        }

        if (from == len - 1) {
            return Math.min(Math.abs(target), Math.abs(nums[from] - target));
        }

        long key = target * 41L + from;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int chooseRes = rec(from + 1, target - nums[from]);
        int nonChooseRes = rec(from + 1, target);
        int ans = Math.min(chooseRes, nonChooseRes);
        memoMap.put(key, ans);
        return ans;
    }

    public int minAbsDifference(int[] nums, int goal) {
        this.nums = nums;
        this.len = nums.length;
        this.goal = goal;
        memoMap = new HashMap<>();
        return rec(0, Math.abs(goal));
    }

}
