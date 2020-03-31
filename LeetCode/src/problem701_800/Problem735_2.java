package problem701_800;

import java.util.Arrays;

/**
 * Problem735_2
 *
 * @author: yry
 * @date: 2020/3/30
 */
public class Problem735_2 {

    public int[] asteroidCollision(int[] arr) {
        // stack
        int n = arr.length;
        int[] stack = new int[n];
        int stackSize = 0;

        for (int num : arr) {
            if (num > 0) {
                stack[stackSize++] = num;
            } else {
                while (stackSize > 0 && stack[stackSize - 1] > 0 && stack[stackSize - 1] < -num) {
                    stackSize--;
                }

                if (stackSize == 0) {
                    stack[stackSize++] = num;
                } else {
                    int top = stack[stackSize - 1];
                    if (top < 0) {
                        stack[stackSize++] = num;
                    } else if (top == -num) {
                        // 两颗一起爆炸
                        stackSize--;
                    }
                }
            }
        }

        return Arrays.copyOf(stack, stackSize);
    }

}
