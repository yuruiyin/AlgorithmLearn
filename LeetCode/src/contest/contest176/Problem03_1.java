package contest.contest176;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem03_1 {

    private static final int MAX = (int) (1e5 + 1);

    public int maxEvents(int[][] events) {
        int len = events.length;
        List<Integer>[] indexListArr = new ArrayList[MAX];

        // 保存每个起点的终点列表
        for (int i = 0; i < len; i++) {
            int start = events[i][0];
            if (indexListArr[start] == null) {
                indexListArr[start] = new ArrayList<>();
            }
            indexListArr[start].add(i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for (int i = 1; i < MAX; i++) {
            if (indexListArr[i] != null) {
                for (Integer j : indexListArr[i]) {
                    pq.offer(events[j][1]);
                }
            }

            while (!pq.isEmpty() && pq.peek() < i) {  // 当前面加入的endTime比i小的话，说明没法参加这个会议了，可以从优先队列中删除。
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }

        return ans;
    }

    private static int[][] createArr() {
        int[][] events = new int[100000][2];
        for (int i = 0; i < 100000; i++) {
            events[i] = new int[]{1, 100000};
        }

        return events;
    }

    public static void main(String[] args) {
        int[][] events = createArr();
        System.out.println(new Problem03_1().maxEvents(events));
    }

}
