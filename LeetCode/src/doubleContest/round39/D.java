package doubleContest.round39;

import utils.TreeMultiSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/14
 */
public class D {

    public boolean canDistribute(int[] nums, int[] quantity) {
//        TreeMultiSet<Integer> set = new TreeMultiSet<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] countArr = new int[1001];
        for (int num : nums) {
            countArr[num]++;
        }

        for (int i = 1; i <= 1000; i++) {
            if (countArr[i] > 0) {
                heap.add(countArr[i]);
            }
        }

        Arrays.sort(quantity);
        int m = quantity.length;

        for (int i = m - 1; i >= 0; i--) {
            int count = quantity[i];
            if (heap.peek() < count) {
                return false;
            }

            int maxCount = heap.poll();
            heap.add(maxCount - count);
        }

        return true;
    }

}
