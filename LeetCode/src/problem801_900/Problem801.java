package problem801_900;

import java.util.Arrays;

public class Problem801 {

    private int[][] memo;
    private int len;

    private int[] nums1;
    private int[] nums2;

    /**
     * 记忆化搜索求解
     *
     * @param prePos 代表数组1前一个数字的位置，0代表未交换，1代表交换
     * @param curIdx 当前元素索引
     */
    private int dp(int prePos, int curIdx) {
        if (curIdx == len) {
            return 0;
        }

        if (memo[prePos][curIdx] != -1) {
            return memo[prePos][curIdx];
        }

        int preNum1 = prePos == 0 ? nums1[curIdx - 1] : nums2[curIdx - 1];
        int preNum2 = prePos == 0 ? nums2[curIdx - 1] : nums1[curIdx - 1];
        if (preNum1 >= nums1[curIdx]) {
            // 数组1必须要交换才能满足严格递增
            if (preNum1 >= nums2[curIdx] || preNum2 >= nums1[curIdx]) {
                // 两个数字都不大于前一个数字，说明当前走不通了
                memo[prePos][curIdx] = len;
                return -2;
            }
            int res = dp(1, curIdx + 1) + 1;
            memo[prePos][curIdx] = res;
            return res;
        }

        // preNum1 < nums1[curIdx]
        if (preNum1 >= nums2[curIdx] || preNum2 >= nums1[curIdx]) {
            // 不能交换
            int res = dp(0, curIdx + 1);
            memo[prePos][curIdx] = res;
            return res;
        }

        if (preNum2 >= nums2[curIdx]) {
            // 必须要交换
            int res = dp(1, curIdx + 1) + 1;
            memo[prePos][curIdx] = res;
            return res;
        }

        // 可交换，可不交换
        int swapRes = dp(1, curIdx + 1) + 1;
        int nonSwapRes = dp(0, curIdx + 1);
        memo[prePos][curIdx] = Math.min(swapRes, nonSwapRes);
        return memo[prePos][curIdx];
    }

    public int minSwap(int[] nums1, int[] nums2) {
        len = nums1.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        memo = new int[2][len];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(memo[i], -1);
        }
        return Math.min(dp(0, 1), dp(1, 1) + 1);
    }

}
