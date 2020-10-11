package contest.contest203;

import java.util.ArrayList;
import java.util.List;

/**
 * A_1
 *
 * @author: yry
 * @date: 2020/8/23
 */
public class A_1 {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int len = rounds.length;
        int first = rounds[0];
        int last = rounds[len - 1];
        List<Integer> ansList = new ArrayList<>();
        if (first <= last) {
            for (int i = first; i <= last; i++) {
                ansList.add(i);
            }
        } else {
            for (int i = 1; i <= last; i++) {
                ansList.add(i);
            }

            for (int i = first; i <= n; i++) {
                ansList.add(i);
            }
        }

        return ansList;
    }

}
