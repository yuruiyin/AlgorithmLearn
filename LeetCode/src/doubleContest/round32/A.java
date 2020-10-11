package doubleContest.round32;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/8
 */
public class A {

    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int count = 0;
        for (int i = 1; i <= 2000; i++) {
            if (!set.contains(i)) {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }

        return -1;
    }

}
