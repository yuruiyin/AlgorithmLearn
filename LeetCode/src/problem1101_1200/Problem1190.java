package problem1101_1200;

import java.util.Stack;

public class Problem1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (int j = 0; j < sb.length(); j++){
                    stack.push(sb.charAt(j));
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder ansSb = new StringBuilder();
        while (!stack.isEmpty()) {
            ansSb.append(stack.pop());
        }

        return ansSb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem1190().reverseParentheses("(abcd)"));
        System.out.println(new Problem1190().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

}
