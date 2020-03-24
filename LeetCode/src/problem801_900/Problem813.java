package problem801_900;

import java.util.Arrays;

/**
 * Problem813
 *
 * @author: yry
 * @date: 2020/3/24
 */
public class Problem813 {

    private double[] preSumArr;
    private int[] arr;
    private int len;
    private double[][] memo;

    private double dp(int idx, int k) {
        if (idx == len) {
            return k == 0 ? 0 : Integer.MIN_VALUE;
        }

        if (len - idx < k || k <= 0) {
            return Integer.MIN_VALUE;
        }

        if (memo[idx][k] != -1) {
            return memo[idx][k];
        }

        double ansMax = 0;
        for (int i = idx; i <= len - k; i++) {
            double sum = idx == 0 ? preSumArr[i] : preSumArr[i] - preSumArr[idx - 1];
            ansMax = Math.max(ansMax, sum / (i - idx + 1) + dp(i + 1, k - 1));
        }

        memo[idx][k] = ansMax;
        return ansMax;
    }

    private void calcPreSum() {
        preSumArr = new double[len];
        preSumArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + arr[i];
        }
    }

    public double largestSumOfAverages(int[] arr, int k) {
        this.arr = arr;
        this.len = arr.length;
        calcPreSum();
        memo = new double[len][len + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, k);
    }

}
