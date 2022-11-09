package contest.contest315;

import utils.TreeMultiSet;

public class D {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int len = nums.length;
        TreeMultiSet<Integer> treeMultiSet = new TreeMultiSet<>();
        long ans = 0;
        long pre = 1;
        for (int i = 0; i < len; i++) {
            treeMultiSet.add(nums[i]);
            if (treeMultiSet.first() == minK && treeMultiSet.last() == maxK) {
                long cur = pre;
                int size = treeMultiSet.size();
                for (int j = i - size + 1; j < i; j++) {
                    treeMultiSet.remove(nums[j]);
                    if (treeMultiSet.first() == minK && treeMultiSet.last() == maxK) {
                        cur++;
                    } else {
                        treeMultiSet.add(nums[j]);
                        break;
                    }
                }
                ans += cur;
                pre = cur;
            } else if (treeMultiSet.first() < minK || treeMultiSet.last() > maxK) {
                treeMultiSet.clear();
                pre = 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().countSubarrays(new int[]{1,1,1,1}, 1, 1));
    }

}
