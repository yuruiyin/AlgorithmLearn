package problem401_500;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Problem414
 *
 * @author: yry
 * @date: 2020/3/24
 */
public class Problem414 {

    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : set) {
            pq.offer(num);
            if (pq.size() > 3) {
                pq.poll();
            }
        }

        if (pq.size() == 3) {
            return pq.peek();
        }

        int max = 0;
        while (!pq.isEmpty()) {
            max = pq.poll();
        }

        return max;
    }

}
