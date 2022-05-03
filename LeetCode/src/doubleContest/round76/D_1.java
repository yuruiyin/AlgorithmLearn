package doubleContest.round76;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.function.Predicate;

/**
 * TLE
 */
public class D_1 {

    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        PriorityQueue<int[]>[] adj = new PriorityQueue[n];
        // 按照分数从大到小排序
        Arrays.setAll(adj, value -> new PriorityQueue<int[]>(3, (o1, o2) -> o1[0] - o2[0]));
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(new int[]{scores[v], v});
            if (adj[u].size() > 3) {
                adj[u].poll();
            }
            adj[v].add(new int[]{scores[u], u});
            if (adj[v].size() > 3) {
                adj[v].poll();
            }
        }

        int ansMax = -1;
        // 枚举中间那条边
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int scoreSum = scores[u] + scores[v];
            for (int[] uNext: adj[u]) {
                if (uNext[1] == v) {
                    continue;
                }
                for (int[] vNext: adj[v]) {
                    if (uNext[1] != vNext[1] && vNext[1] != u) {
                        ansMax = Math.max(ansMax, scoreSum + uNext[0] + vNext[0]);
                    }
                }
            }
        }
        return ansMax;
    }

}
