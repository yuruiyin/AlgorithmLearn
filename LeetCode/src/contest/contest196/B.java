package contest.contest196;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/5
 */
public class B {

    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for (int i = 0; i < left.length; i++) {
            max = Math.max(max, left[i]);
        }

        for (int i = 0; i < right.length; i++) {
            max = Math.max(max, n - right[i]);
        }

        return max;
    }

}
