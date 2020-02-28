package lcci;

import java.util.Stack;

public class Lcci0305 {

    class SortedStack {

        private Stack<Integer> numStack;
        private Stack<Integer> helpStack;

        public SortedStack() {
            numStack = new Stack<>();
            helpStack = new Stack<>();
        }

        public void push(int val) {
            if (numStack.isEmpty() || val <= numStack.peek()) {
                numStack.push(val);
                return;
            }

            // val > stack.peek()
            while (!numStack.isEmpty() && numStack.peek() < val) {
                helpStack.push(numStack.pop());
            }

            numStack.push(val);
            while (!helpStack.isEmpty()) {
                numStack.push(helpStack.pop());
            }
        }

        public void pop() {
            if (numStack.isEmpty()) {
                return;
            }
            numStack.pop();
        }

        public int peek() {
            if (numStack.isEmpty()) {
                return -1;
            }
            return numStack.peek();
        }

        public boolean isEmpty() {
            return numStack.isEmpty();
        }
    }

}
