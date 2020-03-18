import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LintCode461
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode461 {

    public int kthSmallest(int k, int[] nums) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }

}
