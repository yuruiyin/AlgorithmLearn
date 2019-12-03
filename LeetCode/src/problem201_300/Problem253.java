package problem201_300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem253 {

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> endQueue = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // start从小到大排序
            }
        });

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (!endQueue.isEmpty()) {
                if (start >= endQueue.peek()) {
                    // 当前会议开始时间比最小的end时间都小，无需新开一个会议室，直接复用这个会议室即可，即更新end
                    endQueue.poll();
                }
                endQueue.offer(end);
            } else {
                endQueue.offer(end);
            }
        }

        return endQueue.size();
    }

}
