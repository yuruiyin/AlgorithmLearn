package doubleContest.round40;

import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/28
 */
public class C {

    class FrontMiddleBackQueue {

        private LinkedList<Integer> queue;

        public FrontMiddleBackQueue() {
            queue = new LinkedList<>();
        }

        public void pushFront(int val) {
            queue.addFirst(val);
        }

        public void pushMiddle(int val) {
            int size = queue.size();
            int mid = size >>> 1;
            queue.add(mid, val);
        }

        public void pushBack(int val) {
            queue.addLast(val);
        }

        public int popFront() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.removeFirst();
        }

        public int popMiddle() {
            if (queue.isEmpty()) {
                return -1;
            }

            return queue.remove((queue.size() - 1) >>> 1);
        }

        public int popBack() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.removeLast();
        }
    }

}
