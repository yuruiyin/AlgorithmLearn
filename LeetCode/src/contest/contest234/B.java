package contest.contest234;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/28
 */
public class B {

    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        int count = 0;
        int[] tmp = new int[n];
        while (true) {
            count++;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    tmp[i] = arr[i / 2];
                } else {
                    tmp[i] = arr[n / 2 + (i - 1) / 2];
                }
            }

            boolean isOk = true;
            for (int i = 0; i < n; i++) {
                if (tmp[i] != i) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                return count;
            }

            System.arraycopy(tmp, 0, arr, 0, n);
        }
    }

}
