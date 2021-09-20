package contest.contest214;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class A {

    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
        }

        for (int i = 0; i <= n; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

}
