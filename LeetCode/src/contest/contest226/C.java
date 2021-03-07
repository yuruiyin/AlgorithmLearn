package contest.contest226;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/31
 */
public class C {

    private int findFirstBiggerOrEqual(long[] arr, long target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = arr[mid];
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

    public boolean[] canEat(int[] arr, int[][] queries) {
        // [favoriteTypei, favoriteDayi, dailyCapi]
        int n = arr.length;
        long[] preSumArr = new long[n];
        preSumArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preSumArr[i] = preSumArr[i - 1] + arr[i];
        }

        boolean[] ansArr = new boolean[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int type = q[0];
            int day = q[1];
            int maxCount = q[2];
            long maxSum = (day + 1L) * maxCount;
            if (day + 1 > preSumArr[type]) {
                ansArr[i++] = false;
                continue;
            }
            int firstBiggerIdx = findFirstBiggerOrEqual(preSumArr, maxSum);
            if (firstBiggerIdx == -1) {
                ansArr[i++] = true;
                continue;
            }

            if (firstBiggerIdx == 0) {
                ansArr[i++] = type == 0;
                continue;
            }

            if (type < firstBiggerIdx) {
                ansArr[i++] = true;
                continue;
            }

            ansArr[i++] = preSumArr[firstBiggerIdx] == maxSum && type == firstBiggerIdx ||
                    preSumArr[firstBiggerIdx] > maxSum && preSumArr[firstBiggerIdx - 1] < maxSum && type == firstBiggerIdx;
        }
        return ansArr;
    }
    
    public static void main(String[] args) {
        System.out.println(new C().canEat(new int[]{7,4,5,3,8}, new int[][]{
                {0,2,2},
                {4,2,4},
                {2,13,1000000000},
        }));
    }

}
