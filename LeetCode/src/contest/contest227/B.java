package contest.contest227;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/10
 */
public class B {

    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        return Math.min((a + b + c) / 2, arr[0] + arr[1]);
    }

}
