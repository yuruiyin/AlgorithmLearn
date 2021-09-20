package doubleContest.round53;

import java.util.Arrays;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/29
 */
public class D {

    private void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private int[] arr1;
    private int[] arr2;
    private int len;
    private long[] memo;

    private long dp(int from, int flag) {
        if (from == len) {
            return 0;
        }

        if (memo[flag] != -1) {
            return memo[flag];
        }

        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < 14; i++) {
            if ((flag & (1 << i)) == 0) {
                continue;
            }

            flag ^= (1 << i);
            long tmp = (arr1[from] ^ arr2[i]) + dp(from + 1, flag);
            ans = Math.min(ans, tmp);
            flag ^= (1 << i);
        }

        memo[flag] = ans;
        return ans;
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        arr1 = nums1;
        arr2 = nums2;
        this.len = arr1.length;

        memo = new long[1 << len];
        Arrays.fill(memo, -1);
        return (int) dp(0, (1 << len) - 1);
    }

}
