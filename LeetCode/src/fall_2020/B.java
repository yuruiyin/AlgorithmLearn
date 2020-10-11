package fall_2020;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/12
 */
public class B {

    private static final int MOD = 1000000007;

    private int findFirstBigger(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal > target) {
                if (mid == 0 || arr[mid - 1] <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);

        long ans = 0;

        for (int i = 0; i < staple.length; i++) {
            if (staple[i] > x) {
                break;
            }

            int target = x - staple[i];
            int firstBiggerIndex = findFirstBigger(drinks, target);
            if (firstBiggerIndex != -1) {
                ans += firstBiggerIndex;
            } else {
                ans += drinks.length;
            }
        }

        return (int) (ans % MOD);
    }

}
