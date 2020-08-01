package contest.contest198;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/19
 */
public class D_1 {

    public int closestToTarget(int[] arr, int target) {
        int len = arr.length;
        int ansMin = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int cur = 0xffffffff;
            for (int j = i; j < len; j++) {
                cur &= arr[j];
                if (cur <= target) {
                    ansMin = Math.min(ansMin, target - cur);
                    break;
                }

                ansMin = Math.min(ansMin, cur - target);
                if (cur == 0) {
                    break;
                }
            }
        }

        return ansMin;
    }

}
