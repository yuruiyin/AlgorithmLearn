package pre01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * C
 *
 * @author: yry
 * @date: 2020/8/29
 */
public class C {


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

    /**
     * @param heights: the heights of buildings.
     * @param k: the vision.
     * @param x: the energy to spend of the first action.
     * @param y: the energy to spend of the second action.
     * @return: the minimal energy to spend.
     */
    public long shuttleInBuildings(int[] heights, int k, int x, int y) {
        // write your code here.
        // 先求右侧第一个比当前位置高的楼的位置
        int len = heights.length;
        int[] rightFirstGeqIdxArr = getRightFirstGeqIdxArr(heights);
        List<Integer>[] leftIndexListArr = new ArrayList[len];

        for (int i = 0; i < len; i++) {
            int rightFirstGedIdx = rightFirstGeqIdxArr[i];
            if (rightFirstGedIdx == -1) {
                continue;
            }

            if (leftIndexListArr[rightFirstGedIdx] == null) {
                leftIndexListArr[rightFirstGedIdx] = new ArrayList<>();
            }
            leftIndexListArr[rightFirstGedIdx].add(i);
        }

        long[] dp = new long[len];
        dp[1] = heights[1] > heights[0] ? Math.min(x, y) : y;

        for (int i = 2; i < len; i++) {
            long min = Long.MAX_VALUE;
            List<Integer> leftIndexList = leftIndexListArr[i];
            if (leftIndexList != null) {
                int size = leftIndexList.size();
                for (int j = size - 1; j >= 0; j--) {
                    int index = leftIndexList.get(j);
                    if (i - index > k) {
                        break;
                    }

                    min = Math.min(min, dp[index] + x);
                }
            }
            min = Math.min(min, Math.min(dp[i - 1] + y, dp[i - 2] + y));
            dp[i] = min;
        }
        return dp[len - 1];
    }

    private static int[] createData() {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(new C().shuttleInBuildings(new int[]{1,5,4,3,3,5}, 3, 10, 6));
        int[] data = createData();
        System.out.println(new C().shuttleInBuildings(data, 50000, 10, 6));
    }

}
