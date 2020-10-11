package fall_2020;

import java.util.Arrays;

/**
 * B_1
 *
 * @author: yry
 * @date: 2020/9/13
 */
public class B_1 {

    private static final int MOD = 1000000007;

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);

        long ans = 0;
        int r = drinks.length - 1;

        for (int i = 0; i < staple.length; i++) {
            if (staple[i] > x) {
                break;
            }

            while (r >= 0 && drinks[r] + staple[i] > x) {
                r--;
            }

            ans += r + 1;
        }

        return (int) (ans % MOD);
    }

}
