package contest.contest187;

import utils.TreeMultiSet;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/3
 */
public class C {

    public int longestSubarray(int[] nums, int limit) {
        TreeMultiSet<Integer> treeMultiSet = new TreeMultiSet<>();
        int len = nums.length;
        int ansMax = 1;
        treeMultiSet.add(nums[0]);
        int left = 0;
        for (int right = 1; right < len; right++) {
            treeMultiSet.add(nums[right]);
            int max = treeMultiSet.last();
            int min = treeMultiSet.first();
            if (max - min <= limit) {
                ansMax = Math.max(ansMax, right - left + 1);
            } else {
                treeMultiSet.remove(nums[left]);
                left++;
            }
        }

        return ansMax;
    }

}
