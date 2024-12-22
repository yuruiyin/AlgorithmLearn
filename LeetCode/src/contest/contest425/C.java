package contest.contest425;

import java.util.Arrays;
import java.util.Map;

public class C {

    private Integer[][][] dp;

    private int len;

    private int[] sufSumArr;

    private int[] nums;

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private int rec(int idx, int op1, int op2, int k) {
        if (idx == len) {
            return 0;
        }

        if (op1 == 0 && op2 == 0) {
            return sufSumArr[idx];
        }

        if (dp[idx][op1][op2] != null) {
            return dp[idx][op1][op2];
        }

        if (nums[idx] == 0) {
            return dp[idx][op1][op2] = rec(idx + 1, op1, op2, k);
        }

        int res2 = Integer.MAX_VALUE;
        if (op2 == 0) {
            res2 = nums[idx] + rec(idx + 1, op1, 0, k);
        } else {
            if (nums[idx] >= k) {
                res2 = (nums[idx] - k) + rec(idx + 1, op1, op2 - 1, k);
            } else {
                res2 = nums[idx] + rec(idx + 1, op1, 0, k);
            }
        }

        int res1 = Integer.MAX_VALUE;
        if (op1 == 0) {
            res1 = nums[idx] + rec(idx + 1, 0, op2, k);
        } else {
            if (nums[idx] == 1) {
                res1 = nums[idx] + rec(idx + 1, 0, op2, k);
            } else {
                res1 = nums[idx] / 2 + (nums[idx] % 2) + rec(idx + 1, op1 - 1, op2, k);
            }
        }

        int res3 = Integer.MAX_VALUE;
        if (op1 > 0 && nums[idx] > 1 && (op2 > 0 && (nums[idx] / 2 + (nums[idx] % 2) >= k))) {
            res3 = nums[idx] / 2 + (nums[idx] % 2) - k + rec(idx + 1, op1 - 1, op2 - 1, k);
        }

        int res4 = Integer.MAX_VALUE;
        if (op2 > 0 && op1 > 0 && nums[idx] >= k && (nums[idx] - k) > 1) {
            res4 = (nums[idx] - k) / 2 + (nums[idx] - k) % 2 + rec(idx + 1, op1 - 1, op2 - 1, k);
        }

        return dp[idx][op1][op2] = Math.min(Math.min(res1, res2), Math.min(res3, res4));
    }

    private void calcSufSumArr(int[] nums) {
        int len = nums.length;
        sufSumArr = new int[len];
        sufSumArr[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] = sufSumArr[i + 1] + nums[i];
        }
    }

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        sortDesc(nums);
        this.len = nums.length;
        this.nums = nums;

        if (k == 0) {
            // 只能执行Op1
            for (int i = 0; i < op1; i++) {
                nums[i] = nums[i] / 2 + (nums[i] % 2);
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        calcSufSumArr(nums);
        dp = new Integer[len + 1][len + 1][len + 1];
        return rec(0, op1, op2, k);
    }

}
