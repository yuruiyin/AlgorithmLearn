package contest.contest228;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/14
 */
public class D {

    public int minTrioDegree(int n, int[][] edges) {
        int[] degree = new int[n + 1];
        boolean[][] adj = new boolean[n + 1][n + 1];
        for (int[] edge: edges) {
            short u = (short) edge[0];
            short v = (short) edge[1];
            degree[u]++;
            degree[v]++;

            if (adj[u] == null) {
                adj[u] = new boolean[n + 1];
            }
            adj[u][v] = true;

            if (adj[v] == null) {
                adj[v] = new boolean[n + 1];;
            }
            adj[v][u] = true;
        }

        int ansMin = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            short u = (short) edge[0];
            short v = (short) edge[1];
            if (degree[u] < 2 || degree[v] < 2) {
                continue;
            }

            for (int i = 1; i <= n; i++) {
                if (i == u || i == v) {
                    continue;
                }

                boolean[] set = adj[i];
                if (set == null) {
                    continue;
                }

                if (set[u] && set[v]) {
                    ansMin = Math.min(ansMin, degree[u] + degree[v] + degree[i] - 6);
                }
            }
        }

        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;

    }

}
