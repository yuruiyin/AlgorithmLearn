package utils;

/**
 * ArraysUtil
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class ArraysUtil {

    // 使用单调栈获取右边第一个比当前元素大的元素的索引
    public static int[] getRightFirstGreaterIdxArr(int[] height) {
        int len = height.length;
        int[] stack = new int[len];
        int stackSize = 0;
        int[] rightFirstGreaterIdxArr = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            while (stackSize != 0 && height[stack[stackSize - 1]] <= height[i]) {
                stackSize--;
            }

            if (stackSize != 0) {
                rightFirstGreaterIdxArr[i] = stack[stackSize - 1];
            }
            stack[stackSize++] = i;
        }
        return rightFirstGreaterIdxArr;
    }

    // 使用单调栈获取右边第一个比当前元素大或等的元素的索引
    public static int[] getRightFirstGeqIdxArr(int[] height) {
        int len = height.length;
        int[] stack = new int[len];
        int stackSize = 0;
        int[] rightFirstGeqIdxArr = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            while (stackSize != 0 && height[stack[stackSize - 1]] < height[i]) {
                stackSize--;
            }

            if (stackSize != 0) {
                rightFirstGeqIdxArr[i] = stack[stackSize - 1];
            }
            stack[stackSize++] = i;
        }
        return rightFirstGeqIdxArr;
    }

    // 计算右边最大的元素的索引
    public static int[] getRightMaxIdxArr(int[] height) {
        int len = height.length;
        int[] rightMaxIdxArr = new int[len];
        int rightMax = height[len - 1];
        int rightMaxIdx = len - 1;
        rightMaxIdxArr[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            rightMaxIdxArr[i] = rightMaxIdx;
            if (height[i] > rightMax) {
                rightMax = height[i];
                rightMaxIdx = i;
            }
        }
        return rightMaxIdxArr;
    }

}
