package problem2501_2600;

import utils.StrHash;

import java.util.Arrays;

public class Problem2572 {

    private static final int MOD = (int) (1e9 + 7);

    // 30以内的素数集合
    private static final int[] primeArr = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    // 判断一个数是否含有平方因子
    private static boolean[] hasSquareFactor;
    // 30以内每个数的素因子在primeArr中的索引构成的二进制数
    private static int[] primes;

    private int[] arr;
    private int len;
    private int[][] memo;

    private int dp(int pre, int curIdx) {
        if (curIdx == len) {
            return pre == 0 ? 0 : 1;
        }

        if (memo[pre][curIdx] != -1) {
            return memo[pre][curIdx];
        }

        if (hasSquareFactor[arr[curIdx]]) {
            // 当前数就有平方因子了，不能选
            return dp(pre, curIdx + 1);
        }

        // 不选
        long nonChooseRes = dp(pre, curIdx + 1);
        long chooseRes = 0;
        // 注意1可以和任何数组合
        if ((primes[arr[curIdx]] & pre) == 0 || arr[curIdx] == 1) {
            chooseRes = dp(pre | primes[arr[curIdx]], curIdx + 1);
        }

        return memo[pre][curIdx] = (int) ((nonChooseRes + chooseRes) % MOD);
    }

    private void calcPrimes() {
        primes = new int[31];
        primes[1] = 1 << 10;
        for (int i = 1; i <= 30; i++) {
            for (int j = primeArr.length - 1; j >= 0; j--) {
                if (i % primeArr[j] == 0) {
                    primes[i] |= (1 << j);
                }
            }
        }
    }

    private void calcHasSquareFactor() {
        hasSquareFactor = new boolean[31];
        hasSquareFactor[4] = true;
        hasSquareFactor[8] = true;
        hasSquareFactor[9] = true;
        hasSquareFactor[12] = true;
        hasSquareFactor[16] = true;
        hasSquareFactor[18] = true;
        hasSquareFactor[20] = true;
        hasSquareFactor[24] = true;
        hasSquareFactor[25] = true;
        hasSquareFactor[27] = true;
        hasSquareFactor[28] = true;
    }

    public int squareFreeSubsets(int[] arr) {
        if (hasSquareFactor == null) {
            calcHasSquareFactor();
        }

        if (primes == null) {
            calcPrimes();
        }

        this.arr = arr;
        this.len = arr.length;
        // 第11位判断是否取了1
        int size = 1 << 11;
        memo = new int[size][1001];
        for (int i = 0; i < size; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0);
    }

    public static void main(String[] args) {
//        System.out.println(new Problem2572().squareFreeSubsets(new int[]{3, 4, 4, 5}));
//        System.out.println(new Problem2572().squareFreeSubsets(new int[]{1}));
    }

}
