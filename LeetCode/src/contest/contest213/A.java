package contest.contest213;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */

class A {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int len = arr.length;
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1);

        int[] arr2 = new int[len];
        int idx = 0;
        for (int[] piece : pieces) {
            for (int num : piece) {
                arr2[idx++] = num;
            }
        }

        Arrays.sort(arr2);

        if (!Arrays.equals(arr1, arr2)) {
            return false;
        }

        for (int[] piece : pieces) {
            int from = -1;
            for (int j = 0; j < len; j++) {
                if (piece[0] == arr[j]) {
                    from = j;
                    break;
                }
            }

            if (len - from < piece.length) {
                return false;
            }

            for (int j = from + 1, i = 1; j < len & i < piece.length; j++, i++) {
                if (piece[i] != arr[j]) {
                    return false;
                }
            }
        }

        return true;

    }
}