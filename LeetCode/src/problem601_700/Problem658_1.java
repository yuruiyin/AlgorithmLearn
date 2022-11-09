package problem601_700;

import java.util.*;

public class Problem658_1 {

    private int findFirstBiggerOrEqualIdx(int[] arr, int target) {
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 二分找到第一个比x大的
        int firstBiggerOrEqualIdx = findFirstBiggerOrEqualIdx(arr, x);
        int len = arr.length;
        int start = -1;
        if (firstBiggerOrEqualIdx == -1) {
            // 所有的数都比x小，即x是最大的，那么最接近的k个数就是末尾k个数
            start = len - k;
        } else if (firstBiggerOrEqualIdx == 0) {
            start = 0;
        } else {
            int l = firstBiggerOrEqualIdx - 1;
            int r = firstBiggerOrEqualIdx;
            int count = 0;

            while (count < k) {
                if (r >= len) {
                    start = len - k;
                    break;
                }
                if (l < 0) {
                    start = 0;
                    break;
                }

                if (x - arr[l] <= arr[r] - x) {
                    l--;
                } else {
                    r++;
                }
                count++;
            }
            if (start == -1) {
                start = l + 1;
            }
        }

        int finalStart = start;
        return new AbstractList<>() {
            @Override
            public Integer get(int index) {
                return arr[finalStart + index];
            }

            @Override
            public int size() {
                return k;
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(new Problem658_1().findClosestElements(new int[]{1, 3}, 1, 2));
    }

}
