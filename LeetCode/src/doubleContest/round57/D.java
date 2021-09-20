package doubleContest.round57;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/24
 */
public class D {

    // 使用单调栈获取右边第一个比当前元素大的元素的索引
    private int[] getRightFirstGeqIdxArr(int[] height) {
        int len = height.length;
        int[] stack = new int[len];
        int stackSize = 0;
        int[] rightFirstGeqIdxArr = new int[len];
        Arrays.fill(rightFirstGeqIdxArr, -1);

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

    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] rightFirstGeqIdxArr = getRightFirstGeqIdxArr(heights);
        int[] rightUpCountArr = new int[len];
        rightUpCountArr[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (heights[i] < heights[i + 1]) {
                rightUpCountArr[i] = rightUpCountArr[i + 1] + 1;
            } else {
                int rightFirstGreatOrEqualIdx = rightFirstGeqIdxArr[i];
                if (rightFirstGreatOrEqualIdx == -1) {
                    rightUpCountArr[i] = 1;
                } else {
                    if (heights[i] == heights[rightFirstGreatOrEqualIdx]) {
                        rightUpCountArr[i] = rightUpCountArr[rightFirstGreatOrEqualIdx];
                    } else {
                        rightUpCountArr[i] = rightUpCountArr[rightFirstGreatOrEqualIdx] + 1;
                    }
                }
            }
        }

        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int rightFirstGreatOrEqualIdx = rightFirstGeqIdxArr[i];
            if (rightFirstGreatOrEqualIdx == -1) {
                // 右边都比自己小
                ansArr[i] = i == len - 1 ? 0 : rightUpCountArr[i + 1];
            } else {
                if (rightFirstGreatOrEqualIdx == len - 1) {
                    ansArr[i] = rightUpCountArr[i + 1];
                } else {
                    ansArr[i] = rightUpCountArr[i + 1] - rightUpCountArr[rightFirstGreatOrEqualIdx] + 1;
                }
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] ansArr = new D().canSeePersonsCount(new int[]{10,6,8,5,11,9});
    }

}
