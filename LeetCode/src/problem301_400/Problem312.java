package problem301_400;

import java.util.Arrays;

public class Problem312 {

    private int[] memo;

    /**
     * 思路：dp[i][j] 代表戳破[i+1, j-1]气球的最大效益。for循环中的k代表最后被戳破的是第k号气球。
     * 因为是第k号气球被戳破，因此被k分成的左右两半就互相不干扰。所以可以得出以下计算公式。
     * @param nums 收尾都添加1的新数组。
     * @param i 当前计算区域的左边界
     * @param j 当前计算区域的右边界
     * @return 当前区域的最大值
     */
    private int backTracking(int[] nums, int i, int j) {
        if (memo[i * 1000 + j] != -1) {
            return memo[i * 1000 + j];
        }

        int max = 0;
        for (int k = i + 1; k <= j - 1; k++) {
            int value = nums[i] * nums[k] * nums[j] + backTracking(nums, i, k) + backTracking(nums, k, j);
            max = Math.max(value, max);
        }

        memo[i * 1000 + j] = max;
        return max;
    }

    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length + 2;
        int[] newNums = new int[n];
        newNums[0] = 1;
        newNums[n - 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, nums.length);

        memo = new int[n * 1000 + n];
        Arrays.fill(memo, -1);

        return backTracking(newNums, 0, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Problem312().maxCoins(new int[]{3,1,5,8}));
    }

}
