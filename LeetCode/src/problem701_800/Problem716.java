package problem701_800;

import java.util.Stack;

public class Problem716 {

    class MaxStack {

        private Stack<Integer> numStack;
        private Stack<Integer> maxStack;

        /** initialize your data structure here. */
        public MaxStack() {
            numStack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            numStack.push(x);
            if (maxStack.isEmpty()) {
                maxStack.push(x);
                return;
            }

            if (x >= maxStack.peek()) {
                maxStack.push(x);
            }
        }

        public int pop() {
            int top = numStack.pop();
            if (maxStack.peek() == top) {
                maxStack.pop();
            }
            return top;
        }

        public int top() {
            return numStack.peek();
        }

        public int peekMax() {
            if (maxStack.isEmpty()) {
                return -1;
            }
            return maxStack.peek();
        }

        public int popMax() {
            Stack<Integer> tmpStack = new Stack<>();
            if (numStack.isEmpty()) {
                return -1;
            }

            int max = maxStack.pop();
            while (!numStack.isEmpty() && numStack.peek() != max) {
                tmpStack.push(numStack.pop());
            }

            numStack.pop();
            while (!tmpStack.isEmpty()) {
                push(tmpStack.pop());
            }

            return max;
        }
    }

}
