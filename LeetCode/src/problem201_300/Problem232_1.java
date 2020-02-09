package problem201_300;

import java.util.Stack;

public class Problem232_1 {

    class MyQueue {

        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (popStack.isEmpty()) {
                move();
            }

            if (popStack.isEmpty()) {
                return -1;
            }

            return popStack.pop();
        }

        private void move() {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        /** Get the front element. */
        public int peek() {
            if (popStack.isEmpty()) {
                move();
            }

            if (popStack.isEmpty()) {
                return -1;
            }

            return popStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }

}
