package doubleContest.round07;

import java.util.PriorityQueue;

public class Problem1167 {

    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) {
            return sticks[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < sticks.length; i++) {
            queue.add(sticks[i]);
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
