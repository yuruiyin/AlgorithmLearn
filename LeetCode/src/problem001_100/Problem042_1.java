package problem001_100;

/**
 * Problem042_1
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class Problem042_1 {

    // 使用单调栈获取右边第一个比当前元素大的元素的索引
    private int[] getRightFirstGeqIdxArr(int[] height) {
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
    private int[] getRightMaxIdxArr(int[] height) {
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

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int len = height.length;
        int[] rightFirstGeqIdxArr = getRightFirstGeqIdxArr(height);
        int[] rightMaxIdxArr = getRightMaxIdxArr(height);

        int ans = 0;
        for (int i = 0; i < len - 1;) {
            if (height[i] == 0) {
                i++;
                continue;
            }

            int rightFirstGeqIdx = rightFirstGeqIdxArr[i];
            if (rightFirstGeqIdx == 0) {
                // 右边没有比当前柱子高或等的元素，那就寻找右边最大的高度
                int cutRightMaxIdx = rightMaxIdxArr[i];
                for (int j = i + 1; j < cutRightMaxIdx; j++) {
                    ans += height[cutRightMaxIdx] - height[j];
                }

                i = cutRightMaxIdx;
                continue;
            }

            for (int j = i + 1; j < rightFirstGeqIdx; j++) {
                ans += height[i] - height[j];
            }
            i = rightFirstGeqIdx;
        }

        return ans;
    }

}
