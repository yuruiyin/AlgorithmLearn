package problem501_600;

import java.util.Arrays;

/**
 * Problem575_1
 *
 * @author: yry
 * @date: 2020/4/8
 */
public class Problem575_1 {

    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int len = candies.length;
        int ans = 1;
        if (len == 2) {
            return ans;
        }

        for (int i = 1; i < len; i++) {
            if (candies[i] != candies[i - 1]) {
                ans++;
                if (ans == len / 2) {
                    return ans;
                }
            }
        }

        return ans;
    }

}
