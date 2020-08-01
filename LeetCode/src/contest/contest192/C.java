package contest.contest192;

import java.util.Stack;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/7
 */
public class C {

    class BrowserHistory {

        private Stack<String> backStack;
        private Stack<String> forwardStack;

        public BrowserHistory(String homepage) {
            backStack = new Stack<>();
            forwardStack = new Stack<>();
            backStack.push(homepage);
        }

        public void visit(String url) {
            forwardStack.clear();
            backStack.push(url);
        }

        public String back(int steps) {
            int count = 0;
            while (backStack.size() > 1 && count < steps) {
                String url = backStack.pop();
                forwardStack.push(url);
                count++;
            }

            return backStack.peek();
        }

        public String forward(int steps) {
            int count = 0;
            while (!forwardStack.isEmpty() && count < steps) {
                String url = forwardStack.pop();
                backStack.push(url);
                count++;
            }

            return backStack.peek();
        }
    }

}
