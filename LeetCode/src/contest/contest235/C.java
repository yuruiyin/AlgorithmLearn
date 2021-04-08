package contest.contest235;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/4
 */
public class C {

    private static final int MOD = (int) (1e9 + 7);

    private int find(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l++;
            } else {
                r--;
            }
        }
        return -1;
    }

    private int findFirstBiggerOrEqual(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal >= target) {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] sort1 = Arrays.copyOf(nums1, len);
        Arrays.sort(sort1);
        int[] minArr1 = new int[len];
        for (int i = 0; i < len; i++) {
            int firstBiggerOrEqual = findFirstBiggerOrEqual(sort1, nums2[i]);
            if (firstBiggerOrEqual == -1) {
                minArr1[i] = sort1[len - 1];
            } else {
                if (firstBiggerOrEqual == 0) {
                    minArr1[i] = sort1[0];
                } else {
                    if (Math.abs(sort1[firstBiggerOrEqual] - nums2[i]) <= Math.abs(sort1[firstBiggerOrEqual - 1] - nums2[i])) {
                        minArr1[i] = sort1[firstBiggerOrEqual];
                    } else {
                        minArr1[i] = sort1[firstBiggerOrEqual - 1];
                    }
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }

        long ansMin = sum;
        for (int i = 0; i < len; i++) {
            ansMin = Math.min(ansMin, sum - (Math.abs(nums1[i] - nums2[i]) - Math.abs(minArr1[i] - nums2[i])));
        }

        return (int) (ansMin % MOD);
    }

}
