package contest.contest085;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem838 {

    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder ansSb = new StringBuilder();

        for (char c : arr) {
            if (c == '.') {
                stack.push(c);
            } else if (c == 'L') {
                List<Character> charList = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != 'R') {
                    charList.add(stack.pop());
                }

                if (stack.isEmpty()) {
                    // 栈中没有'R'
                    int lCount = charList.size() + 1;
                    while ((lCount--) > 0) {
                        ansSb.append('L');
                    }
                } else {
                    // 栈中有'R'
                    int pointCount = charList.size();
                    int count = pointCount / 2 + 1;
                    for (int i = 0; i < count; i++) {
                        ansSb.append('R');
                    }

                    if (pointCount % 2 == 1) {
                        ansSb.append('.');
                    }

                    for (int i = 0; i < count; i++) {
                        ansSb.append('L');
                    }
                    stack.pop(); // 把R弹出
                }
            } else {
                // 判断左边是否有R，如果有，则弹出
                List<Character> charList = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != 'R') {
                    charList.add(stack.pop());
                }

                if (stack.isEmpty()) {
                    // 栈中没有R
                    int pointCount = charList.size();
                    while ((pointCount--) > 0) {
                        ansSb.append('.');
                    }
                } else {
                    // 栈中有R
                    int rCount = charList.size() + 1;
                    while ((rCount--) > 0) {
                        ansSb.append('R');
                    }
                    stack.pop();
                }
                stack.push('R');
            }
        }

        List<Character> remainList = new ArrayList<>();
        while (!stack.isEmpty()) {
            remainList.add(stack.pop());
        }

        int remainCharSize = remainList.size();
        if (remainCharSize > 0 && remainList.get(remainCharSize - 1) == 'R') {
            while ((remainCharSize--) > 0) {
                ansSb.append('R');
            }
        } else {
            while ((remainCharSize--) > 0) {
                ansSb.append('.');
            }
        }

        return ansSb.toString();
    }

}
