package contest.contest210;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/11
 */
public class B {

    public int maximalNetworkRank(int n, int[][] roads) {
        List<Integer>[] connectRoads = new ArrayList[n];

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            if (connectRoads[u] == null) {
                connectRoads[u] = new ArrayList<>();
            }
            connectRoads[u].add(u * n + v);

            if (connectRoads[v] == null) {
                connectRoads[v] = new ArrayList<>();
            }
            connectRoads[v].add(u * n + v);
        }

        int ansMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (connectRoads[i] == null || connectRoads[j] == null) {
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                set.addAll(connectRoads[i]);
                set.addAll(connectRoads[j]);
                ansMax = Math.max(ansMax, set.size());
            }
        }

        return ansMax;
    }

}
