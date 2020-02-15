package lcof;

import java.util.PriorityQueue;

public class Lcof041_1 {

    class MedianFinder {

        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }

            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

}
