package contest.contest180;

import java.util.LinkedList;
import java.util.Stack;

public class Problem02 {

    class CustomStack {

        private Stack<Integer> stack;
        private int maxSize;

        public CustomStack(int maxSize) {
            stack = new Stack<>();
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (stack.size() == maxSize) {
                return;
            }

            stack.push(x);
        }

        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.pop();
        }

        public void increment(int k, int val) {
            int count = Math.min(k, stack.size());
            for (int i = 0; i < count; i++) {
                stack.set(i, stack.get(i) + val);
            }
        }
    }

}
