package contest.contest187;

import utils.TreeMultiSet;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * C_1
 *
 * @author: yry
 * @date: 2020/5/4
 */
public class C_1 {

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int len = nums.length;
        int ansMax = 1;
        minHeap.add(nums[0]);
        maxHeap.add(nums[0]);
        int left = 0;
        for (int right = 1; right < len; right++) {
            minHeap.add(nums[right]);
            maxHeap.add(nums[right]);
            int max = maxHeap.peek();
            int min = minHeap.peek();
            if (max - min <= limit) {
                ansMax = Math.max(ansMax, right - left + 1);
            } else {
                minHeap.remove(nums[left]);
                maxHeap.remove(nums[left]);
                left++;
            }
        }

        return ansMax;
    }

}
