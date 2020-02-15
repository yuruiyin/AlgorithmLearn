package lcof;

import java.util.Stack;

public class Lcof009 {

    class CQueue {

        private Stack<Integer> numStack;
        private Stack<Integer> helpStack;

        public CQueue() {
            numStack = new Stack<>();
            helpStack = new Stack<>();
        }

        public void appendTail(int value) {
            numStack.push(value);
        }

        public int deleteHead() {
            if (!helpStack.isEmpty()) {
                return helpStack.pop();
            }

            while (!numStack.isEmpty()) {
                helpStack.push(numStack.pop());
            }

            if (helpStack.isEmpty()) {
                return -1;
            }

            return helpStack.pop();
        }
    }


}
