package problem501_600;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem575
 *
 * @author: yry
 * @date: 2020/4/8
 */
public class Problem575 {

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int num : candies) {
            set.add(num);
        }
        return Math.min(candies.length / 2, set.size());
    }

}
