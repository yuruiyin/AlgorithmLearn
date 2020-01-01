package problem801_900;

import java.util.Stack;

public class Problem856 {

    public int scoreOfParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sum += (stack.pop() - '0');
                }

                stack.pop();
                if (sum == 0) {
                    stack.push((char) (1 + '0'));
                } else {
                    stack.push((char) ((sum * 2) + '0'));
                }
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += (stack.pop() - '0');
        }

        return ans;
    }

}
