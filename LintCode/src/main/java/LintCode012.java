import java.util.Stack;

/**
 * LintCode012
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode012 {

    public class MinStack {

        private Stack<Integer> numStack;
        private Stack<Integer> minStack;

        public MinStack() {
            numStack = new Stack<>();
            minStack = new Stack<>();
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(int number) {
            numStack.push(number);
            if (minStack.isEmpty()) {
                minStack.push(number);
                return;
            }

            if (number <= minStack.peek()) {
                minStack.push(number);
            }
        }

        /*
         * @return: An integer
         */
        public int pop() {
            int top = numStack.pop();
            if (minStack.peek() == top) {
                minStack.pop();
            }

            return top;
        }

        /*
         * @return: An integer
         */
        public int min() {
            return minStack.peek();
        }
    }


}
