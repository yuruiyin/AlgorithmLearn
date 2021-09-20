package contest.contest237;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/18
 */
public class B {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        long sum = 0;
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i];
            if (sum > coins) {
                break;
            }
            count++;
        }
        return count;
    }

}
