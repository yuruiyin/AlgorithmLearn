package problem101_200;

import java.util.LinkedList;

/**
 * 使用两个栈的解法（数据栈和最小栈）
 */
public class Problem155_3 {

    class MinStack {

        private LinkedList<Integer> numStack;
        private LinkedList<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            numStack = new LinkedList<>();
            minStack = new LinkedList<>();
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
            if (numStack.isEmpty() || minStack.isEmpty()) {
                return;
            }

            int popNum = numStack.pop();
            if (popNum == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            if (numStack.isEmpty()) {
                return -1;
            }
            return numStack.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                return -1;
            }

            return minStack.peek();
        }
    }

}
