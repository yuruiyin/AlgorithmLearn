package contest.contest186;

import utils.TreeMultiSet;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/26
 */
public class D {

    public int constrainedSubsetSum(int[] nums, int k) {
        TreeMultiSet<Integer> set = new TreeMultiSet<>();
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        set.add(dp[0]);
        int ansMax = dp[0];

        for (int i = 1; i < len; i++) {
            int max = set.last();
            dp[i] = max > 0 ? max + nums[i] : nums[i];
            set.add(dp[i]);
            if (set.size() > k) {
                set.remove(dp[i - k]);
            }
            ansMax = Math.max(ansMax, dp[i]);
        }
        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new D().constrainedSubsetSum(new int[]{10,2,-10,5,20}, 2));
        System.out.println(new D().constrainedSubsetSum(new int[]{10,-2,-10,-5,20}, 2));
    }

}
