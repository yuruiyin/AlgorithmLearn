package contest.contest220;

import utils.TreeMultiSet;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/20
 */
public class C {

    public int maxResult(int[] nums, int k) {
        TreeMultiSet<Integer> treeMultiSet = new TreeMultiSet<>();
        int len = nums.length;
        treeMultiSet.add(nums[0]);
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int max = treeMultiSet.last();
            max += nums[i];
            if (treeMultiSet.size() == k) {
                treeMultiSet.remove(dp[i - k]);
                treeMultiSet.add(max);
            } else {
                treeMultiSet.add(max);
            }
            dp[i] = max;
        }

        return dp[len - 1];
    }

}
