package contest.contest238;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/11
 */
public class B {

    private int find(long[] arr, int[] nums, int to, long k) {
        int l = 0;
        int r = to;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (mid == 0) {
                if (arr[to] + k >= nums[to] * (to + 1)) {
                    return 0;
                }
                l = mid + 1;
                continue;
            }

            if (arr[to] - arr[mid - 1] + k >= nums[to] * (to - mid + 1L)) {
                if (mid > 1 && arr[to] - arr[mid - 2] + k < nums[to] * (to - mid + 2L)) {
                    return mid;
                }

                if (mid == 1 && arr[to] + k < nums[to] * (to + 1)) {
                    return mid;
                }

                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public int maxFrequency(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            int idx = find(preSumArr, nums, i, k);
            ansMax = Math.max(ansMax, i - idx + 1);
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new B().maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(new B().maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(new B().maxFrequency(new int[]{3, 6, 9}, 2));
    }
}
