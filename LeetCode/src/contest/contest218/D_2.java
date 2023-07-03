package contest.contest218;

import java.util.Arrays;

public class D_2 {

    private static final int MAX = 0x3fffffff;

    private int len;

    private int eachCount;

    private int[] arr;

    private int[] memo;

    /**
     * 记忆化搜索
     * @param mask  标识当前剩余的数字，（二进制1代表剩余的数字）
     * @param pre   上一次选择的数字在nums中的位置
     */
    private int dfs(int mask, int pre) {
        if (mask == 0) {
            return 0;
        }

        int key = mask * len + pre;
        if (memo[key] != -1) {
            return memo[key];
        }

        int maskBitCount = Integer.bitCount(mask);
        int mod = maskBitCount % eachCount;
        if (mod == 0) {
            // 选择第一个可用数字作为子集的数字
            int lowbit = Integer.lowestOneBit(mask);
            int res = dfs(mask ^ lowbit, Integer.bitCount(lowbit - 1));
            for (int p = 0; p < len; p++) {
                memo[mask * len + p] = res;
            }
            return res;
        }

        int res = MAX;
        for (int p = pre + 1; p < len; p++) {
            if((mask & (1 << p)) != 0 && arr[p] > arr[pre]) {
                res = Math.min(res, dfs(mask ^ (1 << p), p) + arr[p] - arr[pre]);
            }
        }

        return memo[key] = res;
    }
    public int minimumIncompatibility(int[] nums, int k) {
        this.len = nums.length;

        if (len == k) {
            return 0;
        }

        this.arr = nums;
        int[] countArr = new int[17];
        for (int num: nums) {
            countArr[num]++;
            if (countArr[num] > k) {
                return -1;
            }
            if (k == 1 && countArr[num] > 1) {
                return -1;
            }
        }

        Arrays.sort(arr);

        if (k == 1) {
            return arr[len - 1] - arr[0];
        }

        this.eachCount = len / k;
        memo = new int[1 << 20];
        Arrays.fill(memo, -1);
        return dfs((1 << len) - 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(new D_2().minimumIncompatibility(new int[]{10,4,4,2,11,10,8,9,1,2,2,10}, 4));
    }

}
