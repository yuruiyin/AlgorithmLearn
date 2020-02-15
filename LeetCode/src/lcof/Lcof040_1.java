package lcof;

import java.util.PriorityQueue;

public class Lcof040_1 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        // 大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] ansArr = new int[k];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            ansArr[index++] = maxHeap.poll();
        }

        return ansArr;
    }

}
