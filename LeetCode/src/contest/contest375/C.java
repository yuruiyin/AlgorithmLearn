package contest.contest375;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class C {

    public long countSubarrays(int[] nums, int k) {
//        给你一个整数数组 nums 和一个 正整数 k 。
//
//        请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
//
//        子数组是数组中的一个连续元素序列。
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int len = nums.length;
        LinkedList<Integer> maxNumIndexList = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == max) {
                maxNumIndexList.add(i);
            }
        }
        int size = maxNumIndexList.size();
        if (size < k) {
            return 0;
        }

        int start = maxNumIndexList.get(k - 1);
        long pre = maxNumIndexList.get(0) + 1;
        long ans = pre;
        for (int i = start + 1; i < len; i++) {
            if (nums[i] == max) {
                long cur = pre;
                int first = maxNumIndexList.removeFirst();
                cur += first == i ? 0 : maxNumIndexList.getFirst() - first;
                ans += cur;
                pre = cur;
            } else {
                ans += pre;
            }
        }
        return ans;
    }

}
