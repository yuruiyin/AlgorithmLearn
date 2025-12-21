package contest.contest453;

import java.util.Arrays;

public class C_1 {

    private static final int MOD = (int) (1e9 + 7);

    public int countPartitions(int[] nums, int k) {
        int len = nums.length;
        int[] endIdxArr = new int[len];
        int endIdx = 1;
        for (int i = 0; i < len; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = endIdx; j < len; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (max - min > k) {
                    endIdxArr[i] = j - 1;
                    endIdx = j;
                    break;
                }
                endIdxArr[i] = j;
                endIdx = j + 1;
            }
        }

        long[] sufSumArr = new long[len];
        sufSumArr[len - 1] = 1;
        long[] sufSumSumArr = new long[len];
        sufSumSumArr[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            int curEndIdx = endIdxArr[i];
            if (curEndIdx == len - 1) {
                sufSumArr[i] = (sufSumArr[i + 1] + sufSumSumArr[i + 1]) % MOD;
            } else {
                sufSumArr[i] = (sufSumArr[i + 1] + sufSumSumArr[i + 1] - sufSumSumArr[curEndIdx + 1] + MOD) % MOD;
            }
            sufSumSumArr[i] = (sufSumArr[i]) % MOD;
        }

        return (int) sufSumArr[0];

    }

    public static void main(String[] args) {
//        System.out.println(new C_1().countPartitions(new int[]{3,3,4}, 0));/**/
        System.out.println(new C_1().countPartitions(new int[]{9,4,1,3,7}, 4));
    }

}
