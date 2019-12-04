package problem701_800;

import utils.PrintUtil;

public class Problem739_3 {

    // 逆序遍历，利用已经计算的结果，通过跳跃，减少重复计算
    public int[] dailyTemperatures(int[] tArr) {
        int len = tArr.length;
        int[] ansArr = new int[len];
        ansArr[len - 1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            if (tArr[i] < tArr[i+1]) {
                ansArr[i] = 1;
                continue;
            }

            int rightIndex = i + 1 + ansArr[i+1];
            while (ansArr[rightIndex] != 0 && tArr[rightIndex] <= tArr[i]) {
                rightIndex += ansArr[rightIndex];
            }

            ansArr[i] = tArr[rightIndex] > tArr[i] ? rightIndex - i : 0;
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] ans = new Problem739_3().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});

        PrintUtil.printIntArray(ans);
    }

}
