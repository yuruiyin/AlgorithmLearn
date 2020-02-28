package lcci;

import java.util.Stack;

public class Lcci0302 {

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
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            int popVal = numStack.pop();
            if (popVal == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return numStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
