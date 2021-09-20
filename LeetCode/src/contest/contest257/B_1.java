package contest.contest257;

import java.util.Arrays;
import java.util.Comparator;

/**
 * B_1
 *
 * @author: yry
 * @date: 2021/9/5
 */
public class B_1 {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        int ansCount = 0;
        int preMax = 0;
        for (int[] property : properties) {
            ansCount += property[1] < preMax ? 1 : 0;
            preMax = Math.max(preMax, property[1]);
        }
        return ansCount;
    }

}
