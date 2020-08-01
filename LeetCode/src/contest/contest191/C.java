package contest.contest191;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/31
 */
public class C {

    private List<Integer>[] adj;
    private Set<Long> edgeSet;
    private int n;

    private int dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        List<Integer> nextList = adj[cur];
        int ans = 0;
        for (Integer next : nextList) {
            if (visited[next]) {
                continue;
            }

            if (edgeSet.contains(edgeKey(cur, next))) {
                ans++;
            }

            ans += dfs(next, visited);
        }

        return ans;
    }

    private long edgeKey(int from, int to) {
        return ((long)from) * n + to;
    }

    public int minReorder(int n, int[][] connections) {
        this.n = n;
        adj = new ArrayList[n];
        edgeSet = new HashSet<>();
        for (int[] edge: connections) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);

            if (adj[to] == null) {
                adj[to] = new ArrayList<>();
            }
            adj[to].add(from);

            edgeSet.add(edgeKey(from, to));
        }

        return dfs(0, new boolean[n]);
    }

}
