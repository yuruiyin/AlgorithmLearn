package doubleContest.round25;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/2
 */
public class A {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        int len = candies.length;
        for (int num : candies) {
            max = Math.max(max, num);
        }

        List<Boolean> ansList = new ArrayList<>();
        for (int num : candies) {
            if (num + extraCandies >= max) {
                ansList.add(true);
            } else {
                ansList.add(false);
            }
        }

        return ansList;
    }

}
