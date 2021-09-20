package doubleContest.round51;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/12
 */
public class C {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            }

            arr[i] = arr[i - 1] + 1;
        }

        return arr[len - 1];
    }

}
