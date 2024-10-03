package contest.contest413;

import java.util.Comparator;
import java.util.PriorityQueue;

public class B {

    public int[] resultsArray(int[][] queries, int k) {
        int len = queries.length;
        int[] ans = new int[len];
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < len; i++) {
            int[] q = queries[i];
            int x = q[0];
            int y = q[1];
            heap.add(Math.abs(x) + Math.abs(y));
            if (heap.size() > k) {
                heap.poll();
            }
            if (heap.size() < k) {
                ans[i] = -1;
            } else {
                ans[i] = heap.peek();
            }
        }

        return ans;
    }

}
