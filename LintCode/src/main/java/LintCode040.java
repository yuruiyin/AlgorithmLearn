import java.util.Stack;

/**
 * LintCode040
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode040 {

    public class MyQueue {

        private Stack<Integer> numStack;
        private Stack<Integer> helpStack;

        public MyQueue() {
            numStack = new Stack<>();
            helpStack = new Stack<>();
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            numStack.push(element);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            if (helpStack.isEmpty()) {
                while (!numStack.isEmpty()) {
                    helpStack.push(numStack.pop());
                }
            }

            if (helpStack.isEmpty()) {
                return -1;
            }

            return helpStack.pop();
        }

        /*
         * @return: An integer
         */
        public int top() {
            if (helpStack.isEmpty()) {
                while (!numStack.isEmpty()) {
                    helpStack.push(numStack.pop());
                }
            }

            if (helpStack.isEmpty()) {
                return -1;
            }

            return helpStack.peek();
        }
    }

}
