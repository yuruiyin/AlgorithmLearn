package doubleContest.round34;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/5
 */
public class C {

    private int findFirstBiggerOrEqual(int[] arr, int from, int target) {
        int low = from;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal >= target) {
                if (mid == from || arr[mid - 1] < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int leftEnd = 0;
        int rightStart = len - 1;

        for (int i = 1; i < len; i++) {
            if (arr[i] < arr[i-1]) {
                break;
            }

            leftEnd = i;
        }

        if (leftEnd == len - 1) {
            return 0;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                break;
            }

            rightStart = i;
        }

        int min = Integer.MAX_VALUE;
        for (int i = leftEnd; i >= 0; i--) {
            int target = arr[i];
            int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(arr, rightStart, target);
            if (firstBiggerOrEqualIdx == -1) {
                min = Math.min(min, len - (i + 1));
            } else {
                min = Math.min(min, firstBiggerOrEqualIdx - i - 1);
            }
        }

        min = Math.min(min, rightStart);
        return min;
    }
    
    public static void main(String[] args) {
        System.out.println(new C().findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
    }

}
