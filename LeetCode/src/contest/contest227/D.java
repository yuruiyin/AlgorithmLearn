package contest.contest227;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/10
 */
public class D {

    private int[] nums;
    private int len;
    private Map<Long, Boolean> memoMap;

    private boolean isOk(int from, int target) {
        if (target == 0) {
            return true;
        }

        if (from == len) {
            return false;
        }

        long key = target * 41L + from;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        boolean chooseRes = isOk(from + 1, target - nums[from]);
        boolean nonChooseRes = isOk(from + 1, target);
        boolean ans = chooseRes || nonChooseRes;
        memoMap.put(key, ans);
        return ans;
    }

    public int minAbsDifference(int[] nums, int goal) {
        this.nums = nums;
        this.len = nums.length;
        int l = 0;
        int h = Math.abs(goal);
        memoMap = new HashMap<>();
        int ans = goal;
        while (l <= h) {
            int mid = (l + h) >>> 1;
            if (isOk(0, goal + mid) || isOk(0, goal - mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
