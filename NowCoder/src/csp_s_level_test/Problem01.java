package csp_s_level_test;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem01 {

    static class Main {
        private void solve() {
            Scanner scanner = new Scanner(System.in);
            int s = scanner.nextInt();
            int m = scanner.nextInt();
            int score = 0;
            int ansCount = 0;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            priorityQueue.offer(s);
            while (score < m) {
                int curMax = priorityQueue.poll();
                if (curMax == 1) {
                    ansCount = -1;
                    break;
                }
                int left = curMax / 2;
                int right = curMax - left;
                score += left * right;
                ansCount++;
                priorityQueue.offer(left);
                priorityQueue.offer(right);
            }

            System.out.println(ansCount);
        }

        public static void main(String[] args) {
            new Main().solve();
        }
    }


}
