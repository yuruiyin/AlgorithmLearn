package doubleContest.round33;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/22
 */
public class B {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasEnterArr = new boolean[n];

        for (List<Integer> edge : edges) {
            hasEnterArr[edge.get(1)] = true;
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasEnterArr[i]) {
                ansList.add(i);
            }
        }

        return ansList;
    }

}
