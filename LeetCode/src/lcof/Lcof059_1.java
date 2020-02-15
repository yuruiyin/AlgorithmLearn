package lcof;

import java.util.LinkedList;

public class Lcof059_1 {

    // 单调队列
    class MonotonicQueue {

        private LinkedList<Integer> deque;

        MonotonicQueue() {
            deque = new LinkedList<>();
        }

        public void push(int num) {
            while (!deque.isEmpty() && deque.getLast() < num) {
                deque.removeLast();
            }

            deque.addLast(num);
        }

        public int getMax() {
            return deque.getFirst();
        }

        public void pop(int num) {
            if (!deque.isEmpty() && deque.getFirst() == num) {
                deque.removeFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] ansArr = new int[len - k + 1];
        MonotonicQueue monotonicQueue = new MonotonicQueue();

        for (int i = 0; i < k - 1; i++) {
            monotonicQueue.push(nums[i]);
        }

        int index = 0;
        for (int i = k - 1; i < len; i++) {
            monotonicQueue.push(nums[i]);
            ansArr[index++] = monotonicQueue.getMax();
            monotonicQueue.pop(nums[i-k+1]);
        }

        return ansArr;
    }

}
