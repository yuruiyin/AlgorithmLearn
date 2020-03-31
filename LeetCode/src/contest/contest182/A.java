package contest.contest182;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/29
 */
public class A {

    public int findLucky(int[] arr) {
        int[] count = new int[505];

        for (int num : arr) {
            count[num]++;
        }

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == count[arr[i]]) {
                return arr[i];
            }
        }

        return -1;
    }

}
