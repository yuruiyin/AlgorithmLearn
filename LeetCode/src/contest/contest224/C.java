package contest.contest224;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class C {

    private void reverse(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }

    public int largestSubmatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[] countArr = new int[colCount];
        int ansMax = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                countArr[j] = matrix[i][j] == 1 ? countArr[j] + 1 : 0;
            }

            int[] tmpCountArr = Arrays.copyOf(countArr, colCount);
            Arrays.sort(tmpCountArr);
            reverse(tmpCountArr);
            for (int j = 0; j < colCount; j++) {
                ansMax = Math.max(ansMax, (j + 1) * tmpCountArr[j]);
            }
        }

        return ansMax;
    }

}
