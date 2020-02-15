package lcof;

import java.util.LinkedList;

public class Lcof059_2 {

    class MaxQueue {

        private LinkedList<Integer> numQueue;
        private LinkedList<Integer> maxQueue;

        public MaxQueue() {
            numQueue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.getFirst();
        }

        public void push_back(int value) {
            numQueue.addLast(value);
            if (maxQueue.isEmpty()) {
                maxQueue.addLast(value);
                return;
            }

            while (!maxQueue.isEmpty() && maxQueue.getLast() < value) {
                maxQueue.removeLast();
            }

            maxQueue.addLast(value);
        }

        public int pop_front() {
            if (numQueue.isEmpty()) {
                return -1;
            }

            int front = numQueue.removeFirst();
            if (maxQueue.getFirst() == front) {
                maxQueue.removeFirst();
            }

            return front;
        }
    }

}
