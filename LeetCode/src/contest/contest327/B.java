package contest.contest327;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            heap.add(num);
        }

        long ans = 0;
        while ((k--) > 0) {
            int top = heap.poll();
            ans += top;
//            heap.add((int) Math.ceil(top / 3.0));
            heap.add((top + 2) / 3);
        }

        return ans;
    }

}
