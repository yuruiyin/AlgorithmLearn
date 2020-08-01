package contest.contest195;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/30
 */
public class C {

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

    private void calc2Pow(long[] powArr) {
        powArr[0] = 1;
        for (int i = 1; i< powArr.length; i++) {
            powArr[i] = (powArr[i-1] * 2) % MOD;
        }
    }

    public int numSubseq(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);

        long[] powArr = new long[len + 1];
        calc2Pow(powArr);
        long ans = 0;

        for (int i = 0; i < len; i++) {
            // 以当前数为最小
            int min = nums[i];
            if (i != len - 1) {
                int diff = target - min;
                int idx = findLastSmallerOrEqual(nums, i + 1, len - 1, diff);
                if (idx != -1) {
                    ans = (ans + powArr[idx - i] - 1) % MOD;
                }
            }

            if (nums[i] + nums[i] <= target) {
                ans = (ans + 1) % MOD;
            }
        }

        return (int) ans % MOD;
    }
    
    public static void main(String[] args) {
        System.out.println(new C().numSubseq(new int[]{
                3, 5, 6, 7
        }, 9));
    }

}
