package problem901_1000;

public class Problem977_1 {

    // 寻找最右边的非正数
    private int findMid(int[] arr) {
        int len = arr.length;
        if (arr[len - 1] <= 0) {
            return len - 1;
        }

        if (arr[0] > 0) {
            return -1;
        }

        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal == 0) {
                return mid;
            } else if (midVal > 0) {
                high = mid - 1;
            } else {
                if (mid == len - 1 || arr[mid + 1] > 0) {
                    return mid;
                }
                low = mid + 1;
            }
        }

        return -1;
    }

    public int[] sortedSquares(int[] arr) {
        int len = arr.length;
        int[] ansArr = new int[len];

        int mid = findMid(arr);

        if (mid == -1) {
            // 都是正数
            for (int i = 0; i < len; i++) {
                ansArr[i] = arr[i] * arr[i];
            }

            return ansArr;
        }

        int left = mid;
        int right = mid + 1;
        int index = 0;
        while (left >= 0 && right < len) {
            int squareLeft = arr[left] * arr[left];
            int squareRight = arr[right] * arr[right];
            if (squareLeft < squareRight) {
                ansArr[index++] = squareLeft;
                left--;
            } else {
                ansArr[index++] = squareRight;
                right++;
            }
        }

        while (left >= 0) {
            ansArr[index++] = arr[left] * arr[left];
            left--;
        }

        while (right < len) {
            ansArr[index++] = arr[right] * arr[right];
            right++;
        }

        return ansArr;
    }

}
