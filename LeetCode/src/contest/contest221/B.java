package contest.contest221;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/27
 */
public class B {

    class Data {
        int apple;
        int day;
        Data(int apple, int day) {
            this.apple = apple;
            this.day = day;
        }
    }

    public int eatenApples(int[] apples, int[] days) {
        int len = apples.length;
        int ans = 0;
        // 原则，如果在某一天有多个能吃的苹果，则先吃最早腐烂的苹果
        PriorityQueue<Data> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.day));
        for (int i = 0; ; i++) {
            if (i < len && apples[i] != 0) {
                heap.add(new Data(apples[i], i + days[i]));
            }

            while (!heap.isEmpty() && heap.peek().day <= i) {
                heap.poll();
            }

            if (i >= len && heap.isEmpty()) {
                break;
            }

            if (!heap.isEmpty()) {
                ans++;
                Data front = heap.peek();
                if (front.apple == 1) {
                    heap.poll();
                } else {
                    front.apple--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new B().eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
    }
}
