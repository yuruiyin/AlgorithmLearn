package doubleContest.round48;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/20
 */
public class C {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int len = coins.length;

        if (coins[0] != 1) {
            return 1;
        }

        int preSum = coins[0];
        for (int i = 1; i < len; i++) {
            if (coins[i] > preSum + 1) {
                return preSum + 1;
            }
            preSum += coins[i];
        }

        return preSum + 1;
    }

}
