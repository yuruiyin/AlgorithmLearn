import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LintCode544
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode544 {

    public int[] topk(int[] nums, int k) {
        // write your code here
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] ansArr = new int[k];
        List<Integer> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }

        Collections.reverse(list);
        for (int i = 0; i < k; i++) {
            ansArr[i] = list.get(i);
        }

        return ansArr;
    }

}
