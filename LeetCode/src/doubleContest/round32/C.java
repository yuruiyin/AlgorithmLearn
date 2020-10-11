package doubleContest.round32;

import java.util.Stack;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/8
 */
public class C {

    public int minInsertions(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        Stack<Character> stack = new Stack<>();

        int ans = 0;

        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    if (i == len - 1) {
                        ans += 2;
                        break;
                    } else {
                        if (arr[i + 1] == ')') {
                            ans++;
                            i++;
                        } else {
                            ans += 2;
                        }
                    }
                    continue;
                }

                if (i == len - 1) {
                    ans++;
                    stack.pop();
                    break;
                } else {
                    if (arr[i + 1] == ')') {
                        stack.pop();
                        i++;
                    } else {
                        ans++;
                        stack.pop();
                    }
                }
            }
        }

        ans += stack.size() * 2;
        return ans;
    }

}
