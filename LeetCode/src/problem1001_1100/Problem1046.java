package problem1001_1100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int stone: stones) {
            priorityQueue.add(stone);
        }

        while (!priorityQueue.isEmpty()) {
            if (priorityQueue.size() == 1) {
                return priorityQueue.poll();
            }

            int y = priorityQueue.poll();
            int x = priorityQueue.poll();
            if (y > x) {
                priorityQueue.add(y-x);
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
    
}
