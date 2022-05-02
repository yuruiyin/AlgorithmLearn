package contest.contest290;

import java.util.Arrays;

public class D_1 {

    private int findLastSmallerOrEqual(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal <= target) {
                if (mid == len - 1 || arr[mid + 1] > target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int fLen = flowers.length;
        int[] starts = new int[fLen];
        int[] ends = new int[fLen];
        for (int i = 0; i < fLen; i++) {
            int[] f = flowers[i];
            starts[i] = f[0];
            ends[i] = f[1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int len = persons.length;
        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int startLastSmallerOrEqualIdx = findLastSmallerOrEqual(starts, persons[i]);
            int endLastSmallerOrEqualIdx = findLastSmallerOrEqual(ends, persons[i] - 1);
            if (endLastSmallerOrEqualIdx == -1) {
                ansArr[i] = startLastSmallerOrEqualIdx + 1;
            } else {
                ansArr[i] = startLastSmallerOrEqualIdx - endLastSmallerOrEqualIdx;
            }
        }
        return ansArr;
    }

}
