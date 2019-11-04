package contest.contest161;

import java.util.Stack;

public class Problem1249 {

    public String minRemoveToMakeValid(String s) {
        int leftCount = 0;
        int rightCount = 0;
        int len = s.length();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (leftCount > rightCount) {
                    stack.push(c);
                    sb.append(c);
                    rightCount++;
                }
            } else if (c == '(') {
                stack.push(c);
                sb.append(c);
                leftCount++;
            } else  {
                stack.push(c);
                sb.append(c);
            }
        }

        if (leftCount == rightCount) {
            return sb.toString();
        }

        StringBuilder sb1 = new StringBuilder();

        while (!stack.isEmpty()) {
            char c = stack.pop();

            if (c == '(') {
                if (leftCount == rightCount) {
                    sb1.append(c);
                } else {
                    leftCount--;
                }
            } else {
                sb1.append(c);
            }
        }

        return sb1.reverse().toString();

    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1249().minRemoveToMakeValid("())()((("));
    }
    
}
