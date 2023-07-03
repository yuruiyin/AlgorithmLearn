package doubleContest.round106;

import java.util.Arrays;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    public int sumDistance(int[] nums, String s, int d) {
        int len = nums.length;
        long[] nums1 = new long[len];
        for (int i = 0; i < len; i++) {
            nums1[i] = nums[i];
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'L') {
                nums1[i] -= d;
            } else {
                nums1[i] += d;
            }
        }

        Arrays.sort(nums1);
        long ans = 0;
        long pre = 0;
        for (int i = 1; i < len; i++) {
            pre = (pre + (nums1[i] - nums1[i - 1]) * i) % MOD;
            ans = (ans + pre) % MOD;
        }

        return (int) ans;
    }

}
