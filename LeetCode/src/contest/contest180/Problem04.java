package contest.contest180;

import java.util.*;

public class Problem04 {

    private static final int MOD = 1000000007;

    class Data {
        long speed;
        long eff;
        Data(long speed, long eff) {
            this.speed = speed;
            this.eff = eff;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // 排序
        Data[] datas = new Data[n];
        for (int i = 0; i < n; i++) {
            datas[i] = new Data(speed[i], efficiency[i]);
        }

        Arrays.sort(datas, (o1, o2) -> Long.compare(o2.eff, o1.eff));

        long ansMax = datas[0].speed * datas[0].eff;
        PriorityQueue<Long> heap = new PriorityQueue<>(k);
        heap.offer(datas[0].speed);
        long sum = heap.peek();
        for (int i = 1; i < n; i++) {
            long min = datas[i].eff;
            long curSpeed = datas[i].speed;
            if (heap.size() < k) {
                sum += datas[i].speed;
                heap.offer(curSpeed);
            } else {
                if (curSpeed > heap.peek()) {
                    sum -= heap.poll();
                    sum += curSpeed;
                    heap.offer(curSpeed);
                }
            }

            ansMax = Math.max(ansMax, min * sum);
        }

        return (int) (ansMax % MOD);
    }


}
