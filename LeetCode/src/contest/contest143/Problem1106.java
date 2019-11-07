package contest.contest143;

import java.util.Stack;

public class Problem1106 {

    public boolean parseBoolExpr(String expression) {
        char[] arr = expression.toCharArray();
        int len = arr.length;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = arr[i];

            if (c == ')') {
                int fCount = 0;
                int tCount = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == 't') {
                        tCount++;
                    } else if (top == 'f') {
                        fCount++;
                    }
                }
                stack.pop(); // (
                char operation = stack.pop();
                if (operation == '!') {
                    if (fCount > 0) {
                        stack.push('t');
                    } else {
                        stack.push('f');
                    }
                } else if (operation == '&') {
                    if (fCount == 0) {
                        stack.push('t');
                    } else {
                        stack.push('f');
                    }
                } else {
                    if (tCount != 0) {
                        stack.push('t');
                    } else {
                        stack.push('f');
                    }
                }

            } else {
                stack.push(c);
            }
        }

        char ans = stack.pop();
        return ans == 't';
    }
    
    public static void main(String[] args) {
        
    }
    
}
