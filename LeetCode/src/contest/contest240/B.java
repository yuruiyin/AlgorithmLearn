package contest.contest240;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/9
 */
public class B {

    private int findLastBiggerIndex(int[] arr, int from, int target) {
        int len = arr.length;
        int l = from;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) {
                if (mid == len - 1 || arr[mid + 1] < target) {
                    return mid;
                }

                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int ansMax = 0;
        for (int i = 0; i < len1; i++) {
            int index = findLastBiggerIndex(nums2, i, nums1[i]);
            if (index != -1) {
                ansMax = Math.max(ansMax, index - i);
            }
        }

        return ansMax;
    }

}
