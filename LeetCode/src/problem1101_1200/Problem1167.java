package problem1101_1200;

import java.util.PriorityQueue;

public class Problem1167 {

    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int stick : sticks) {
            queue.add(stick);
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            Integer first = queue.poll();
            if (queue.isEmpty()) {
                break;
            }
            int second = queue.poll();
            int sum = first + second;
            ans += sum;
            queue.add(sum);
        }

        return ans;
    }
    
    public static void main(String[] args) {

    }
    
}
