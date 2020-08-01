package contest.contest196;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/5
 */
public class A {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int diff = arr[1] - arr[0];
        for (int i = 2; i < len; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

}
