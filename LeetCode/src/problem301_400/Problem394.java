package problem301_400;

import java.util.Stack;

public class Problem394 {

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private String reverse(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    private String duplicate(String s, int time) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < time; i++) {
            sb.append(s);
        }

        return sb.toString();
    }

    public String decodeString(String s) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                int j;
                for (j = i + 1; j < len; j++) {
                    if (!isNumber(s.charAt(j))) {
                        break;
                    }
                }
                // j-1是number
                int num = Integer.parseInt(s.substring(i, j));
                numStack.push(num);
                i = j-1;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!charStack.isEmpty() && charStack.peek() != '[') {
                    sb.append(charStack.pop());
                }
                charStack.pop();

                String str = reverse(sb.toString());
                int num = numStack.pop();
                String str1 = duplicate(str, num);
                for (int j = 0; j < str1.length(); j++) {
                    charStack.push(str1.charAt(j));
                }
            } else {
                // [,a,b
                charStack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()) {
            sb.append(charStack.pop());
        }

        return reverse(sb.toString());
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem394().decodeString("3[a]2[bc]"));
        System.out.println(new Problem394().decodeString("3[a2[c]]"));
        System.out.println(new Problem394().decodeString("2[abc]3[cd]ef"));

    }
    
}
