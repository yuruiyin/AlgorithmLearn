package doubleContest.round23;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class D {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int ansMax = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int index = 1;
            for (int j = i; j < n; j++) {
                sum += index * satisfaction[j];
                index++;
            }

            ansMax = Math.max(ansMax, sum);
        }
        return ansMax;
    }

}
