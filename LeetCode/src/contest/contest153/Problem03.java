package contest.contest153;

import java.util.ArrayList;
import java.util.List;

public class Problem03 {

    private int getSubArrMaxSum(int[] arr, int negativeIndex) {
        int n = arr.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
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

        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
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

        int prevMax = getSubArrMaxSum(arr, -1);

        int ans = 0;
        for (Integer negativeIndex : negativeIndexArr) {
            int negativeValue = arr[negativeIndex];
            if (prevMax - negativeValue <= ans) {
                continue;
            }

            int max = getSubArrMaxSum(arr, negativeIndex);

            if (max > ans) {
                ans = max;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem03().maximumSum(new int[]{1,-2,0,3}));
        System.out.println(new Problem03().maximumSum(new int[]{1,-2,-2,3}));
        System.out.println(new Problem03().maximumSum(new int[]{-1,-1,-1,-1}));

    }
    
    
}
