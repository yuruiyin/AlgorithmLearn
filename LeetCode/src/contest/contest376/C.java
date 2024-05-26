package contest.contest376;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

    private static final List<Integer> palindromes = new ArrayList<>();

    private int findFirstBiggerIdx(int[] arr, long target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target) {
                if (mid == 0 || arr[mid - 1] <= target) {
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private long getAns(long target, int[] nums, long ansMin, long[] preSumArr, long[] sufSumArr, int len) {
        int firstBiggerIdx = findFirstBiggerIdx(nums, target);
        if (firstBiggerIdx == -1) {
            ansMin = Math.min(ansMin, target * len - preSumArr[len - 1]);
        } else {
            long value = firstBiggerIdx == 0
                    ? (sufSumArr[firstBiggerIdx] - (long)(len - firstBiggerIdx) * target)
                    : (target * firstBiggerIdx - preSumArr[firstBiggerIdx - 1] +
                    sufSumArr[firstBiggerIdx] - (long)(len - firstBiggerIdx) * target);
            ansMin = Math.min(ansMin, value);
        }
        return ansMin;
    }

    private int reverse(int num) {
        int ans = 0;
        while (num > 0) {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return ans;
    }

    private void calcPalindromes() {
        for (int left = 1; left <= 10000; left++) {
            StringBuilder right = new StringBuilder(left + "").reverse();
            long num = Long.parseLong(left + String.valueOf(right));
            if (num < 1e9) {
                palindromes.add((int) num);
            }
            for (int mid = 0; mid <= 9; mid++) {
                long num1 = Long.parseLong(left + String.valueOf(mid) + right);
                if (num1 < 1e9) {
                    palindromes.add((int) num1);
                }
            }
        }
    }

    public long minimumCost(int[] nums) {
        if (palindromes.isEmpty()) {
            calcPalindromes();
        }
        int len = nums.length;
        Arrays.sort(nums);
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }
        long[] sufSumArr = new long[len];
        sufSumArr[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] = sufSumArr[i + 1] + nums[i];
        }

        long ansMin = Long.MAX_VALUE;
        for (int i = 1; i <= 9; i++) {
            ansMin = getAns(i, nums, ansMin, preSumArr, sufSumArr, len);
        }

        for (int palindrome : palindromes) {
            ansMin = getAns(palindrome, nums, ansMin, preSumArr, sufSumArr, len);
        }

        return ansMin;
    }

    public static void main(String[] args) {
        // [207,211,218,220,225,228]
        int[] nums = new int[100000];
        for (int i = 0; i < 100000; i++) {
            nums[i] = (int) 999999999;
        }
//        System.out.println(new C().minimumCost(new int[]{207,211,218,220,225,228}));
        System.out.println(new C().minimumCost(nums));
    }

}
