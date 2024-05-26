package contest.contest372;

import java.util.Arrays;

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

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] rightFirstGeqIdxArr = getRightFirstGeqIdxArr(heights);
        int[] ansArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int minIdx = Math.min(q[0], q[1]);
            int maxIdx = Math.max(q[0], q[1]);
            if (minIdx == maxIdx || heights[minIdx] < heights[maxIdx]) {
                ansArr[i] = maxIdx;
                continue;
            }

            while (rightFirstGeqIdxArr[maxIdx] != -1 && heights[rightFirstGeqIdxArr[maxIdx]] <= heights[minIdx]) {
                maxIdx = rightFirstGeqIdxArr[maxIdx];
            }
            ansArr[i] = rightFirstGeqIdxArr[maxIdx];
        }
        return ansArr;
    }

}
