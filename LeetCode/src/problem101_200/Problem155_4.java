package problem101_200;

import java.util.LinkedList;

/**
 * 定义一个类，包含最小值
 */
public class Problem155_4 {

    class MinStack {

        class Node {
            int value;
            int min;
            Node(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }

        private LinkedList<Node> stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new Node(x, x));
                return;
            }

            int newMin = Math.min(x, stack.peek().min);
            stack.push(new Node(x, newMin));
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek().value;
        }

        public int getMin() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek().min;
        }
    }


}
