package spring_2021_personal;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/5
 */
public class A {

    private static final int MOD = 1000000007;

    private int findLastSmallerOrEqual(int[] arr, int from, int to, int target) {
        int low = from;
        int high = to;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal <= target) {
                if (mid == to || arr[mid + 1] > target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int purchasePlans(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] >= target) {
                break;
            }

            int lastSmallerOrEqualIdx = findLastSmallerOrEqual(nums, 0, i - 1, target - nums[i]);
            if (lastSmallerOrEqualIdx == -1) {
                break;
            }

            ans = (ans + lastSmallerOrEqualIdx + 1) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
