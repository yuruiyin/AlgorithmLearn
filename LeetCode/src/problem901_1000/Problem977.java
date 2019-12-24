package problem901_1000;

import java.util.Arrays;

public class Problem977 {

    public int[] sortedSquares(int[] arr) {
        int len = arr.length;
        int[] ansArr = new int[len];

        for (int i = 0; i < len; i++) {
            ansArr[i] = arr[i] * arr[i];
        }

        Arrays.sort(ansArr);

        return ansArr;
    }

}
