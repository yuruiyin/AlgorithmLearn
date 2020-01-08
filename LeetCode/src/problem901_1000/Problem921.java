package problem901_1000;

import java.util.Stack;

public class Problem921 {

    public int minAddToMakeValid(String str) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();

        for (char c: str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    ans++;
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            ans++;
            stack.pop();
        }

        return ans;
    }

}
