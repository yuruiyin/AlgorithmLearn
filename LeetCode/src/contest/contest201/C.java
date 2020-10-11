package contest.contest201;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/9
 */
public class C {

    public int maxNonOverlapping(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        indexMap.put(nums[0], 0);
        int preSum = nums[0];
        int[] dp = new int[len];
        if (preSum == target) {
            dp[0] = 1;
        }

        for (int i = 1; i < len; i++) {
            preSum += nums[i];
            if (indexMap.containsKey(preSum - target)) {
                dp[i] = i - indexMap.get(preSum - target);
            }

            indexMap.put(preSum, i);
        }

        int ans = 0;
        int pre = -1;
        for (int i = 0; i < len; i++) {
            if (dp[i] == 0) {
                continue;
            }

            if (i - pre >= dp[i]) {
                ans++;
                pre = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C().maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
    }

}
