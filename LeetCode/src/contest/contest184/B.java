package contest.contest184;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/12
 */
public class B {

    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        int[] ansArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int index = -1;
            for (int j = 0; j < m; j++) {
                if (list.get(j) == query) {
                    index = j;
                    break;
                }
            }
            ansArr[i] = index;
            list.remove(index);
            list.add(0, query);
        }

        return ansArr;
    }

}
