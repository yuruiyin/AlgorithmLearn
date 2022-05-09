package problem701_800;

import java.util.LinkedList;

public class Problem707 {

    class MyLinkedList {

        private LinkedList<Integer> queue;

        public MyLinkedList() {
            queue = new LinkedList<>();
        }

        public int get(int index) {
            if (index < 0 || index >= queue.size()) {
                return -1;
            }
            return queue.get(index);
        }

        public void addAtHead(int val) {
            queue.addFirst(val);
        }

        public void addAtTail(int val) {
            queue.addLast(val);
        }

        public void addAtIndex(int index, int val) {
            if (index > queue.size()) {
                return;
            }

            index = Math.max(0, index);
            queue.add(index, val);
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= queue.size()) {
                return;
            }
            queue.remove(index);
        }
    }

    public static void main(String[] args) {

    }

}
