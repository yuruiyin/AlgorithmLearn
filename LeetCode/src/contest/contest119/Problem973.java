package contest.contest119;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem973 {


    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]);
            }
        });

        int[][] ans = new int[k][2];
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll();
        }

        return ans;
    }

}
