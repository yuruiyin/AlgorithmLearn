package lcof;

import java.util.Stack;

public class Lcof030 {

    class MinStack {

        private Stack<Integer> numStack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            numStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            numStack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
                return;
            }

            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (numStack.isEmpty()) {
                return;
            }

            int top = numStack.pop();
            if (minStack.peek() == top) {
                minStack.pop();
            }
        }

        public int top() {
            return numStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

}
