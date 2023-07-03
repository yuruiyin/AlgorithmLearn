package doubleContest.round104;

import java.util.Arrays;

public class D {

    private static final int MOD = 1000000007;

    public int sumOfPower(int[] nums) {
        int len = nums.length;
        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }
        int ans = 0;
        Arrays.sort(arr);
        ans = (int) ((ans + ((arr[0] * arr[0]) % MOD) * arr[0]) % MOD);
        if (len == 1) {
            return ans;
        }

        ans = (int) ((ans + ((arr[1] * arr[1]) % MOD) * arr[1]) % MOD);
        ans = (int) ((ans + ((arr[1] * arr[1]) % MOD) * arr[0]) % MOD);
        if (len == 2) {
            return ans;
        }

        long pre = arr[0];
        for (int i = 2; i < len; i++) {
            pre = (int) ((pre * 2 + arr[i - 1]) % MOD);
            ans = (int) ((ans + ((arr[i] * arr[i]) % MOD) * (pre + arr[i])) % MOD);
        }

        return ans;
    }

}
