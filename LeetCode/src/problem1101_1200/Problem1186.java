package problem1101_1200;

import java.util.ArrayList;
import java.util.List;

public class Problem1186 {
    private int[] getSubArrMaxSum(int[] arr, int negativeIndex) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            if (negativeIndex != -1) {
                value = i == negativeIndex ? 0 : arr[i];
            }
            if (dp[i-1] <= 0) {
                dp[i] = value;
            } else {
                dp[i] = dp[i-1] + value;
            }
        }

        return dp;
    }

    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }

        List<Integer> negativeIndexArr = new ArrayList<>();
        int max1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                negativeIndexArr.add(i);
            }

            if (arr[i] > max1) {
                max1 = arr[i];
            }
        }

        if (negativeIndexArr.size() == n) {
            // 全是负数
            return max1;
        }


        int prevMax = Integer.MIN_VALUE;
        int[] dp = getSubArrMaxSum(arr, -1);
        for (int i = 0; i < n; i++) {
            if (dp[i] > prevMax) {
                prevMax = dp[i];
            }
        }

        int ans = prevMax;
        for (Integer negativeIndex : negativeIndexArr) {
            int negativeValue = arr[negativeIndex];
            // 删除负数就两种情况，如 1, -2, 3 和-1,-2,3。删除中间的-2。也就是说最大值会加2；
            // （1）对第一种情况，最大值加2还是小于目前的最大值，那么肯定不是删除这个负数
            // (2) 对第二种情况，也就是arr[negativeIndex] == dp[negativeIndex]，这种情况删了不影响结果，因此也可忽略
            if (prevMax - negativeValue <= ans) {
                continue;
            }

            if (dp[negativeIndex] == arr[negativeIndex]) {
                continue;
            }

            int[] dp1 = getSubArrMaxSum(arr, negativeIndex);

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (dp1[i] > max) {
                    max = dp1[i];
                }
            }

            if (max > ans) {
                ans = max;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1186().maximumSum(new int[]{1,-2,0,3}));
        System.out.println(new Problem1186().maximumSum(new int[]{1,-2,-2,3}));
        System.out.println(new Problem1186().maximumSum(new int[]{-1,-1,-1,-1}));
        System.out.println(new Problem1186().maximumSum(new int[]{2,9,-4,7,-6,5,8,-5,-6,9}));

    }

}
