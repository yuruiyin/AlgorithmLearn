package contest.contest401;

import java.util.Arrays;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int valueAfterKSeconds(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        while ((k--) > 0) {
            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i] + arr[i - 1]) % MOD;
            }
        }
        return arr[n - 1];
    }

}
