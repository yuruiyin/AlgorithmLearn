package problem201_300;

import java.util.LinkedList;

public class Problem239 {

    class MonotonicQueue {
        private LinkedList<Integer> deque;

        MonotonicQueue() {
            deque = new LinkedList<>();
        }

        // 插入新元素的时候，把队列前面比他小的元素都删除，保持队列单调递减
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
        if (nums.length == 0) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int n = nums.length;

        // 构建单调队列
        MonotonicQueue monotonicQueue = new MonotonicQueue();

        // 先将前k-1个插入队列
        for (int i = 0; i < k-1; i++) {
            monotonicQueue.push(nums[i]);
        }

        int[] ansArr = new int[n - k + 1];
        int index = 0;
        for (int i = k-1; i < n; i++) {
            monotonicQueue.push(nums[i]);
            ansArr[index++] = monotonicQueue.getMax();
            monotonicQueue.pop(nums[i-k+1]);
        }

        return ansArr;
    }
    
    public static void main(String[] args) {
//        int[] ansArr = new Problem239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);

        int[] ansArr = new Problem239().maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);

        for (int num : ansArr) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
    
}
