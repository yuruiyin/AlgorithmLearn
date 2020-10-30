package contest.contest211;

import dsu.TreeDSU;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/18
 */
public class D {

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        TreeDSU dsu = new TreeDSU(n);

        for (int factor = n / 2 + 1; factor > threshold; factor--) {
            List<Integer> list = new ArrayList<>();
            for (int k = 1; k * factor <= n; k++) {
                list.add(k * factor);
            }

            int size = list.size();
            for (int i = 0; i < size; i++) {
                int node1 = list.get(i);
                for (int j = i + 1; j < size; j++) {
                    int node2 = list.get(j);
                    dsu.union(node1 - 1, node2 - 1);
                }
            }
        }

        List<Boolean> ansList = new ArrayList<>();
        for (int[] query : queries) {
            int node1 = query[0];
            int node2 = query[1];
            ansList.add(dsu.connected(node1 - 1, node2 - 1));
        }

        return ansList;
    }

}
