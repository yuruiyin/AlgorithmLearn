package contest.contest176;

import java.util.*;

public class Problem04_1 {

    public boolean isPossible(int[] target) {
        int n = target.length;
        if (n == 1) {
            return target[0] == 1;
        }

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += target[i];
            priorityQueue.offer((long) target[i]);
        }

        while (true) {
            long curMax = priorityQueue.poll();
            if (curMax == 1) {
                return true;
            }

            if (sum - curMax >= curMax) {
                return false;
            }

            long time = curMax / (sum - curMax); // 需要减多少次
            long newNum = curMax - time * (sum - curMax);
            priorityQueue.offer(newNum);
            sum = sum - curMax + newNum;
        }

    }
    
    public static void main(String[] args) {
        System.out.println(new Problem04_1().isPossible(new int[]{9, 3, 5}));
        System.out.println(new Problem04_1().isPossible(new int[]{1000000000, 1}));
        System.out.println(new Problem04_1().isPossible(new int[]{999999999, 1}));
    }

}
