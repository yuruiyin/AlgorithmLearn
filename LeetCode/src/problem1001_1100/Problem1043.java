package problem1001_1100;

import java.util.Arrays;

public class Problem1043 {

    private int[] memo;

    private int backTrack(int[][] maxArr, int k, int from) {
        int len = maxArr.length;
        if (from == len) {
            return 0;
        }

        if (memo[from] != -1) {
            return memo[from];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = from; i < from + k && i < len; i++) {
            int res = backTrack(maxArr, k, i + 1);
            int sum = maxArr[i][from] * (i - from + 1) + res;
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        memo[from] = maxSum;

        return maxSum;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int[][] maxArr = new int[len][len];

        maxArr[0][0] = arr[0];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    maxArr[i][j] = arr[i];
                } else {
                    maxArr[i][j] = Math.max(maxArr[i-1][j], arr[i]);
                }
            }
        }

        memo = new int[len];
        Arrays.fill(memo, -1);

        return backTrack(maxArr, k, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Problem1043().maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }
}
