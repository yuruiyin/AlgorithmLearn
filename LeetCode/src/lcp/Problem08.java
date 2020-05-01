package lcp;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class Problem08 {

    private int findFirstBigger(int[][] arr, int i, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid][i];
            if (midVal >= target) {
                if (mid == 0 || arr[mid - 1][i] < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] getTriggerTime(int[][] incs, int[][] reqs) {
        int incLen = incs.length;
        int reqLen = reqs.length;
        int[] ansArr = new int[reqLen];

        int[][] preSumArr = new int[incLen + 1][3];
        for (int i = 0; i < 3; i++) {
            preSumArr[1][i] = incs[0][i];
        }

        for (int i = 2; i <= incLen; i++) {
            int[] inc = incs[i-1];
            for (int j = 0; j < 3; j++) {
                preSumArr[i][j] = preSumArr[i - 1][j] + inc[j];
            }
        }

        // 二分
        for (int i = 0; i < reqLen; i++) {
            int[] req = reqs[i];
            int maxIndex = -1;
            boolean isOk = true;
            for (int j = 0; j < 3; j++) {
                int firstBiggerIndex = findFirstBigger(preSumArr, j, req[j]);
                if (firstBiggerIndex == -1) {
                    isOk = false;
                    break;
                }

                maxIndex = Math.max(maxIndex, firstBiggerIndex);
            }

            if (!isOk) {
                ansArr[i] = -1;
            } else {
                ansArr[i] = maxIndex;
            }
        }

        return ansArr;
    }

}
