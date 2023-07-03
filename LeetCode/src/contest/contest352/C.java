package contest.contest352;

import utils.TreeMultiSet;

import java.util.TreeSet;

public class C {

    public long continuousSubarrays(int[] nums) {
        int len = nums.length;
        TreeMultiSet<Integer> treeSet = new TreeMultiSet<>();
        treeSet.add(nums[0]);
        long ans = 1;
        long pre = 1;
        for (int i = 1; i < len; i++) {
            treeSet.add(nums[i]);
            while (treeSet.last() - treeSet.first() > 2) {
                treeSet.remove(nums[i + 1 - treeSet.size()]);
            }
            pre = treeSet.size();
            ans += pre;
        }
        return ans;
    }

}
