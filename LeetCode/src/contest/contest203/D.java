package contest.contest203;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/23
 */
public class D {

    private int[][] memo;
    private int[] arr;
    private int len;
    private int[] preSumArr;

    private int dp(int l, int r) {
        if (l == r) {
            return 0;
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int ansMax = 0;
        for (int i = l; i < r; i++) {
            int leftSum = l == 0 ? preSumArr[i] : preSumArr[i] - preSumArr[l - 1];
            int rightSum = preSumArr[r] - preSumArr[i];
            int value;
            if (leftSum == rightSum) {
                value = Math.max(rightSum + dp(i + 1, r), leftSum + dp(l, i));
            } else if (leftSum > rightSum) {
                value = rightSum + dp(i + 1, r);
            } else {
                value = leftSum + dp(l, i);
            }

            ansMax = Math.max(ansMax, value);
        }

        memo[l][r] = ansMax;
        return ansMax;
    }

    private void calcPreSumArr() {
        preSumArr = new int[len];
        preSumArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + arr[i];
        }
    }

    public int stoneGameV(int[] stoneValue) {
        this.arr = stoneValue;
        this.len = arr.length;

        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }

        calcPreSumArr();
        return dp(0, len - 1);
    }

}
