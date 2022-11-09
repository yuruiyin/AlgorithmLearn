package contest.contest318;

import utils.TreeMultiSet;

import java.util.HashSet;
import java.util.Set;

public class B {

    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        int len = nums.length;
        TreeMultiSet<Integer> set = new TreeMultiSet<>();
        long ansMax = 0;
        long sum = 0;
        for (int r = 0; r < len; r++) {
            set.add(nums[r]);
            sum += nums[r];
            while (set.diffElementSize() > k || set.diffElementSize() != (r - l + 1)) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            if (set.diffElementSize() == k && set.diffElementSize() == (r - l + 1)) {
                ansMax = Math.max(ansMax, sum);
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new B().maximumSubarraySum(new int[]{1,1,2}, 2));
    }

}
