package problem1101_1200;

import java.util.Arrays;

public class Problem1191 {

    private static final int MOD = (int) (1e9 + 7);

    private int getMaxSum(int[] arr) {
        int maxSum = 0;
        int prevMaxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prevMaxSum = arr[i];
            } else {
                if (prevMaxSum > 0) {
                    prevMaxSum += arr[i];
                } else {
                    prevMaxSum = arr[i];
                }
            }

            if (prevMaxSum > maxSum) {
                maxSum = prevMaxSum;
            }
        }
        return maxSum;
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        int negativeCount = 0;
        int sum = 0;

        for (int value : arr) {
            if (value < 0) {
                negativeCount++;
            }
            sum += value;
        }

        if (negativeCount == n) {
            // 都是负数
            return 0;
        }

        if (negativeCount == 0) {
            // 都是非负数
            int ans = 0;
            for (int i = 0; i < k; i++) {
                ans = (ans + sum) % MOD;
            }
            return ans;
        }

        // 计算单次数组中的最大子数组的和

        int maxSum = getMaxSum(arr);
        // 有负数有正数
        if (k == 1) {
            return maxSum;
        }

        int[] doubleArr = Arrays.copyOf(arr, 2*n);

//        for (int i = 0; i < n; i++) {
//            doubleArr[i] = arr[i];
//        }
//
        for (int i = n; i < 2*n; i++) {
            doubleArr[i] = doubleArr[i-n];
        }

        int doubleMaxSum = getMaxSum(doubleArr);

        if (doubleMaxSum == maxSum) {
            return maxSum;
        }

        if (k == 2) {
            return doubleMaxSum;
        }

        // 再串联一次
//        int[] arr2 = new int[3*n];
        int[] threeArr = Arrays.copyOf(doubleArr, 3*n);
        for (int i = 2*n; i < 3*n;i++) {
            threeArr[i] = threeArr[i - 2*n];
        }

        int threeMaxSum = getMaxSum(threeArr);

        if (threeMaxSum == doubleMaxSum) {
            return doubleMaxSum;
        }

        int value = 0;
        int diff = doubleMaxSum - maxSum;
        for (int i = 0; i < k - 1; i++) {
            value = (value + diff) % MOD;
        }

        return maxSum + value;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1191().kConcatenationMaxSum(new int[]{1,2}, 3));
        System.out.println(new Problem1191().kConcatenationMaxSum(new int[]{1,-2,1}, 5));
        System.out.println(new Problem1191().kConcatenationMaxSum(new int[]{-1,-2}, 7));
//
        System.out.println(new Problem1191().kConcatenationMaxSum(new int[]{-1,2,3,-2}, 3));
    }
}
