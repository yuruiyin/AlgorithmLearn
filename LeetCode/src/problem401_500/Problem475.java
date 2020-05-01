package problem401_500;

import java.util.Arrays;

/**
 * Problem475
 *
 * @author: yry
 * @date: 2020/4/16
 */
public class Problem475 {

    private int findFirstBigger(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal > target) {
                if (mid == 0 || arr[mid - 1] <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int findLastSmaller(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal < target) {
                if (mid == len - 1 || arr[mid + 1] >= target) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int find(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal == target) {
                return mid;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        // 找所有房屋最接近的供暖器、然后求所有最小值的最大值
        int ansMax = 0;
        for (int house: houses) {
            int equalIndex = find(heaters, house);
            if (equalIndex >= 0) {
                continue;
            }

            int firstBiggerIndex = findFirstBigger(heaters, house);
            int minDis = Integer.MAX_VALUE;
            if (firstBiggerIndex >= 0) {
                minDis = heaters[firstBiggerIndex] - house;
            }

            int lastSmallerIndex = findLastSmaller(heaters, house);
            if (lastSmallerIndex >= 0) {
                minDis = Math.min(minDis, house - heaters[lastSmallerIndex]);
            }

            ansMax = Math.max(ansMax, minDis);
        }
        return ansMax;
    }

}
