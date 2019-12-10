package problem1001_1100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1057 {

    class Data {
        int worker;
        int bike;
        Data(int worker, int bike) {
            this.worker = worker;
            this.bike = bike;
        }
    }

    class CustomCmp implements Comparator<Data> {
        @Override
        public int compare(Data o1, Data o2) {
            if (o1.bike == o2.bike) {
                return o1.worker - o2.worker;
            }

            return o1.bike - o2.bike;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Data>[] distanceQueue = new PriorityQueue[2001];
        Comparator comparator = new CustomCmp();

        int workerLen = workers.length;
        int bikeLen = bikes.length;

        for (int i = 0; i < workerLen; i++) {
            for (int j = 0; j < bikeLen; j++) {
                int[] worker = workers[i];
                int[] bike = bikes[j];
                int dis = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                if (distanceQueue[dis] == null) {
                    distanceQueue[dis] = new PriorityQueue<>(comparator);
                }
                distanceQueue[dis].offer(new Data(i, j));
            }
        }

        int[] ans = new int[workerLen];
        boolean[] workerVisited = new boolean[workerLen];
        boolean[] bikeVisited = new boolean[bikeLen];

        for (int i = 1; i < 2001; i++) {
            PriorityQueue<Data> queue = distanceQueue[i];
            if (queue == null) {
                continue;
            }

            while (!queue.isEmpty()) {
                Data front = queue.poll();
                int worker = front.worker;
                int bike = front.bike;
                if (workerVisited[worker] || bikeVisited[bike]) {
                    continue;
                }

                ans[worker] = bike;
                workerVisited[worker] = true;
                bikeVisited[bike] = true;
            }
        }

        return ans;
    }

}
