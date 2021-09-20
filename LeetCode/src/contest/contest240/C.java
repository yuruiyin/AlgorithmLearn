package contest.contest240;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/9
 */
public class C {

    private static final int MOD = (int) (1e9 + 7);

    // 使用单调栈获取右边第一个比当前元素大的元素的索引
    public int[] getRightFirstSmallerIdxArr(int[] height) {
        int len = height.length;
        int[] stack = new int[len];
        int stackSize = 0;
        int[] rightFirstSmallerIdxArr = new int[len];
        Arrays.fill(rightFirstSmallerIdxArr, -1);

        for (int i = len - 1; i >= 0; i--) {
            while (stackSize != 0 && height[stack[stackSize - 1]] >= height[i]) {
                stackSize--;
            }

            if (stackSize != 0) {
                rightFirstSmallerIdxArr[i] = stack[stackSize - 1];
            }
            stack[stackSize++] = i;
        }
        return rightFirstSmallerIdxArr;
    }

    public int[] getLeftFirstSmallerIdxArr(int[] height) {
        int len = height.length;
        int[] stack = new int[len];
        int stackSize = 0;
        int[] leftFirstSmallerIdxArr = new int[len];
        Arrays.fill(leftFirstSmallerIdxArr, -1);

        for (int i = 0; i < len; i++) {
            while (stackSize != 0 && height[stack[stackSize - 1]] >= height[i]) {
                stackSize--;
            }

            if (stackSize != 0) {
                leftFirstSmallerIdxArr[i] = stack[stackSize - 1];
            }
            stack[stackSize++] = i;
        }
        return leftFirstSmallerIdxArr;
    }

    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        long ansMax = 0;
        int[] rightFirstSmallerIdxArr = getRightFirstSmallerIdxArr(nums);
        int[] leftFirstSmallerIdxArr = getLeftFirstSmallerIdxArr(nums);
        for (int i = 0; i < len; i++) {
            int rightFirstSmallerIdx = rightFirstSmallerIdxArr[i];
            int leftFirstSmallerIdx = leftFirstSmallerIdxArr[i];
            long rightValue;
            if (rightFirstSmallerIdx == -1) {
                // 右侧都不比当前元素小
                rightValue = nums[i] * (preSumArr[len - 1] - (i == 0 ? 0 : preSumArr[i - 1]));
            } else {
                rightValue = nums[i] * (preSumArr[rightFirstSmallerIdx - 1] -  (i == 0 ? 0 : preSumArr[i - 1]));
            }

            long leftValue;
            if (leftFirstSmallerIdx == -1) {
                // 左侧都不比当前元素小
                leftValue = nums[i] * preSumArr[i];
            } else {
                leftValue = nums[i] * (preSumArr[i] - preSumArr[leftFirstSmallerIdx]);
            }

            if (i == 0) {
                ansMax = Math.max(ansMax, rightValue);
            } else if (i == len - 1) {
                ansMax = Math.max(ansMax, leftValue);
            } else {
                ansMax = Math.max(ansMax, leftValue + rightValue - ((long) nums[i]) * nums[i]);
            }
        }

        return (int) (ansMax % MOD);
    }
    
    public static void main(String[] args) {
        System.out.println(new C().maxSumMinProduct(new int[]{1,2,3,2}));
    }

}
