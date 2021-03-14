package contest.contest232;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/14
 */
public class C {

    class Data {
        double pass;
        double total;
        Data(double pass, double total) {
            this.pass = pass;
            this.total = total;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Double.compare((o2.pass + 1) / (o2.total + 1) - o2.pass / o2.total,  (o1.pass + 1) / (o1.total + 1) - o1.pass / o1.total);
            }
        });

        for (int[] arr : classes) {
            heap.add(new Data(arr[0], arr[1]));
        }

        while ((extraStudents--) > 0) {
            Data min = heap.poll();
            heap.add(new Data(min.pass + 1, min.total + 1));
        }

        double ans = 0;
        while (!heap.isEmpty()) {
            Data data = heap.poll();
            ans += data.pass / data.total;
        }

        return ans / classes.length;
    }

}
