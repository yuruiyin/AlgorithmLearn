import java.util.PriorityQueue;

/**
 * LintCode005
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode005 {

    public int kthLargestElement(int k, int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }

}
