package lcci;

import java.util.Arrays;

/**
 * Lcci1606
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class Lcci1606 {

    private int findNearestIndex(int[] arr, int from, long target) {
        int low = from;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = arr[mid];
            if (midVal >= target) {
                if (mid == from) {
                    return mid;
                } else if (arr[mid - 1] < target) {
                    if (Math.abs(arr[mid - 1] - target) <= Math.abs(midVal - target)) {
                        return mid - 1;
                    } else {
                        return mid;
                    }
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return arr.length - 1;
    }

    public int smallestDifference(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int min = Integer.MAX_VALUE;
        int from = 0;
        for (int i = 0; i < arr1.length; i++) {
            int nearestIndex = findNearestIndex(arr2, from, arr1[i]);
            min = (int) Math.min(min, Math.abs((long) arr1[i] - arr2[nearestIndex]));
            from = nearestIndex;
        }
        return min;
    }

}
