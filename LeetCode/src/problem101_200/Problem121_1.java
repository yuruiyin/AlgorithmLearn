package problem101_200;

import java.util.LinkedList;
import java.util.Stack;

public class Problem121_1 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        LinkedList<Integer> queue = new LinkedList<>();  // 单调递减队列

        for (int i = n - 1; i  >= 0; i--) {
            if (queue.isEmpty()) {
                queue.addLast(prices[i]);
            }
            if (prices[i] <= queue.getFirst()) {
                if (prices[i] < queue.getLast()) {
                    queue.addLast(prices[i]);
                }
                continue;
            }

            int diff = queue.getFirst() - queue.getLast();
            if (diff > max) {
                max = diff;
            }

            while (!queue.isEmpty()) {
                queue.poll();
            }

            queue.addLast(prices[i]);
        }

        if (!queue.isEmpty()) {
            int diff = queue.getFirst() - queue.getLast();
            if (diff > max) {
                max = diff;
            }
        }

        return max;
    }
    
    public static void main(String[] args) {

    }
}
