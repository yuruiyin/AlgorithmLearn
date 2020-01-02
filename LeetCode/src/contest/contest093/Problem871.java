package contest.contest093;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // 贪心
        if (startFuel >= target) {
            return 0;
        }

        PriorityQueue<Integer> pqFuel = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int curPos = 0;
        int curFuel = startFuel;
        int stationCount = 0;
        int stationFrom = 0;
        while (true) {
            curPos += curFuel; // 能开到的距离
            if (curPos >= target) {
                return stationCount;
            }

            int i;
            for (i = stationFrom; i < stations.length; i++) {
                if (stations[i][0] > curPos) {
                    break;
                }

                pqFuel.offer(stations[i][1]);
            }

            if (pqFuel.isEmpty()) {
                return -1;
            }

            stationFrom = i;
            curFuel = pqFuel.poll();
            stationCount++;
        }
    }

}
