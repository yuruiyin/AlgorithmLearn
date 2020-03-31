package problem701_800;

import java.util.Stack;

/**
 * Problem735_1
 *
 * @author: yry
 * @date: 2020/3/30
 */
public class Problem735_1 {

    public int[] asteroidCollision(int[] arr) {
        // stack
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (num > 0) {
                stack.push(num);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    stack.push(num);
                } else {
                    int top = stack.peek();
                    if (top < 0) {
                        stack.push(num);
                    } else if (top == -num) {
                        // 两颗一起爆炸
                        stack.pop();
                    }
                }
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

}
