package contest.contest168;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1296_1 {

    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;

        if (len % k != 0) {
            return false;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);

        for (int num : nums) {
            minHeap.offer(num);
        }

        while (!minHeap.isEmpty()) {
            int top = minHeap.poll();

            for (int i = 1; i < k; i++) {
                if (!minHeap.remove(top + i)) {
                    return false;
                }
            }
        }

        return true;
    }


}
