package problem201_300;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem227 {

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public int calculate(String s) {
        // 先处理乘除
        Stack<String> stack = new Stack<>();

        // 先去除空格
        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c != ' '){
                charList.add(c);
            }
        }

        int len = charList.size();

        for (int i = 0; i < len; i++) {
            char c = charList.get(i);
            if (c == ' ') {
                continue;
            }

            switch (c) {
                case '*':
                case '/':
                    String top = stack.pop();
                    int leftNum = Integer.parseInt(top);
                    int rightNum = 0;
                    int j;
                    for (j = i + 1; j < len; j++) {
                        if (!isNum(charList.get(j))) {
                           break;
                        }
                        rightNum = rightNum * 10 + (charList.get(j) - '0');
                    }

                    int res = c == '*' ? leftNum * rightNum : leftNum / rightNum;
                    stack.push(String.valueOf(res));
                    i = j - 1;
                    break;
                case '+':
                case '-':
                    stack.push(c + "");
                    break;
                default:
                    // 数字
                    int num = 0;
                    int k;
                    for (k = i; k < len; k++) {
                        if (!isNum(charList.get(k))) {
                            break;
                        }
                        num = num * 10 + (charList.get(k) - '0');
                    }

                    stack.push(String.valueOf(num));
                    i = k - 1;
                    break;
            }
        }

        Stack<String> ansStack = new Stack<>();

        while (!stack.isEmpty()) {
            ansStack.push(stack.pop());
        }

        // 再处理加减
        int rightNum = Integer.parseInt(ansStack.pop());
        while (!ansStack.isEmpty()) {
            String top = ansStack.pop();
            if (top.equals("+")) {
                int leftNum = Integer.parseInt(ansStack.pop());
                rightNum = rightNum + leftNum;
            } else {
                int leftNum = Integer.parseInt(ansStack.pop());
                rightNum = rightNum - leftNum;
            }
        }

        return rightNum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem227().calculate(" 3/2 "));
    }

}
