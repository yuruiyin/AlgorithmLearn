package problem801_900;

import java.util.LinkedList;

public class Problem862_1 {

    public int shortestSubarray(int[] arr, int k) {
        int len = arr.length;

        if (arr[0] >= k) {
            return 1;
        }

        long[] prevSum = new long[len];
        prevSum[0] = arr[0];
        for (int i = 1; i < len; i++) {
            prevSum[i] = prevSum[i-1] + arr[i];
        }

        LinkedList<Integer> deque = new LinkedList<>();
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && prevSum[i] <= prevSum[deque.getLast()]) {
                deque.removeLast();
            }

            while (!deque.isEmpty() && prevSum[i] - prevSum[deque.getFirst()] >= k) {
                minLen = Math.min(minLen, i - deque.removeFirst());
            }

            if (prevSum[i] >= k) {
                minLen = Math.min(minLen, i + 1);
            }

            deque.addLast(i);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem862_1().shortestSubarray(new int[]{2,-1,2}, 3));
    }

}
