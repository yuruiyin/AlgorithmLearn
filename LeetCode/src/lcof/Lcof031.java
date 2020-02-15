package lcof;

import java.util.Stack;

public class Lcof031 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = popped.length;
        if (len == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[1000];
        int pushIndex = 0;
        for (int popNum : popped) {
            if (visited[popNum]) {
                // 已经压入栈中
                if (stack.peek() != popNum) {
                    return false;
                }

                stack.pop();
            } else {
                int i;
                for (i = pushIndex; i < len; i++) {
                    if (pushed[i] == popNum) {
                        break;
                    }

                    stack.push(pushed[i]);
                    visited[pushed[i]] = true;
                }
                pushIndex = i + 1;
            }
        }

        return true;
    }

}
