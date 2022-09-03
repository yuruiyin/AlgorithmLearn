package contest.contest305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {

    private int dfs(int cur, List<Integer>[] adj, boolean[] restrict, boolean[] visited) {
        visited[cur] = true;
        List<Integer> nextList = adj[cur];
        int res = 1;
        for (int next : nextList) {
            if (visited[next] || restrict[next]) {
                continue;
            }
            res += dfs(next, adj, restrict, visited);
        }
        return res;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] restrict = new boolean[n];
        for (int num : restricted) {
            restrict[num] = true;
        }
        return dfs(0, adj, restrict, new boolean[n]);
    }

}
