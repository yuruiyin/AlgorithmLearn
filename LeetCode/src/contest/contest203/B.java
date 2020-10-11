package contest.contest203;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/23
 */
public class B {

    public int maxCoins(int[] arr) {
        int ans = 0;
        Arrays.sort(arr);
        int len = arr.length;
        int count = 0;

        for (int i = len - 2; i >= 0; i-=2) {
            ans += arr[i];
            count++;
            if (count == len / 3) {
                break;
            }
        }

        return ans;
    }

}
