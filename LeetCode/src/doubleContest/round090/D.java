package doubleContest.round090;

import javax.xml.crypto.Data;
import java.util.*;

public class D {

    class Data {
        int idx;
        int value;
        Data(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

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

    public int[] secondGreaterElement(int[] nums) {
        int len = nums.length;
        int[] ansArr = new int[len];
        Arrays.fill(ansArr, -1);
        if (len <= 2) {
            return ansArr;
        }

        int[] rightFirstGeqIdxArr = getRightFirstGeqIdxArr(nums);
        List<Integer>[] indexListArr = new ArrayList[len];
        Arrays.setAll(indexListArr, value -> new ArrayList<>());
        for (int i = 0; i < len; i++) {
            int rightGeqIdx = rightFirstGeqIdxArr[i];
            if (rightGeqIdx == -1) {
                continue;
            }
            indexListArr[rightGeqIdx].add(i);
        }

        int[] stack = new int[len];
        int stackSize = 0;
        int[] rightFirstGeqIdxArr1 = new int[len];
        Arrays.fill(rightFirstGeqIdxArr1, -1);
        stack[stackSize] = nums[len - 1];

        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println(new D().secondGreaterElement(new int[]{2,4,0,9,6}));
    }

}
