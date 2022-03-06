package contest.contest274;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2022/1/2
 */
public class C {

    public boolean asteroidsDestroyed(int mass, int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        long cur = mass;
        for (int i = 0; i < len; i++) {
            if (cur < arr[i]) {
                return false;
            }
            cur += arr[i];
        }
        return true;
    }

}
