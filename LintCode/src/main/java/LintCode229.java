import java.util.Stack;

/**
 * LintCode229
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode229 {

    public void stackSorting(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<>();
        int count = 0;

        while (count < stack.size()) {
            int min = stack.pop();
            while (stack.size() > count) {
                int top = stack.pop();
                if (top < min) {
                    helpStack.push(min);
                    min = top;
                } else {
                    helpStack.push(top);
                }
            }

            stack.push(min);
            count++;
            while (!helpStack.isEmpty()) {
                stack.push(helpStack.pop());
            }
        }
    }

}
