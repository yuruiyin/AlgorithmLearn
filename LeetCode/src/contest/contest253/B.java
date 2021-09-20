package contest.contest253;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/8
 */
public class B {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int sum = 0;
        for (int num : piles) {
            heap.add(num);
            sum += num;
        }

        while ((k--) > 0) {
            int max = heap.poll();
            if (max == 1) {
                return sum;
            }

            sum -= max / 2;
            heap.add(max - max / 2);
        }
        return sum;
    }

}
