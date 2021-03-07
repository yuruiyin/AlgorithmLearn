package contest.contest217;

import java.util.Arrays;

/**
 * A_1
 *
 * @author: yry
 * @date: 2020/11/29
 */
public class A_1 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] arr : accounts) {
            max = Math.max(max, Arrays.stream(arr).sum());
        }
        return max;
    }

}
