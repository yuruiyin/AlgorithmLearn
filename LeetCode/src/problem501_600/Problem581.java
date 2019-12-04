package problem501_600;

import java.util.PriorityQueue;

public class Problem581 {

    public int findUnsortedSubarray(int[] nums) {
        // 两种优先队列
        int len = nums.length;
        PriorityQueue<Integer> smallTopQueue = new PriorityQueue<>();
        PriorityQueue<Integer> bigTopQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num: nums) {
            smallTopQueue.offer(num);
            bigTopQueue.offer(num);
        }

        int start = -1;
        for (int i = 0; i < len; i++) {
            if (smallTopQueue.peek() == nums[i]) {
                smallTopQueue.poll();
            } else {
                start = i;
                break;
            }
        }

        if (start == -1) {
            // 说明序列原本就是升序
            return 0;
        }

        int end = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (bigTopQueue.peek() == nums[i]) {
                bigTopQueue.poll();
            } else {
                end = i;
                break;
            }
        }

        return end - start + 1;
    }

}
