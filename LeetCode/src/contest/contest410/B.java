package contest.contest410;

import java.util.*;

public class B {

    private List<Integer>[] adj;
    private int[] countArr;

    private int ansCount = 0;

    private int dfsCount(int idx, boolean[] visited) {
        List<Integer> nextList = adj[idx];
        int count = 1;
        for (int next : nextList) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            count += dfsCount(next, visited);
        }
        return countArr[idx] = count;
    }

    private void dfs(int idx, boolean[] visited) {
        List<Integer> nextList = adj[idx];
        Set<Integer> set = new HashSet<>();
        for (int next : nextList) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            int count = countArr[next];
            set.add(count);
            dfs(next, visited);
        }
        if (set.size() <= 1) {
            ansCount++;
        }
    }

    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        adj = new ArrayList[n];
        countArr = new int[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfsCount(0, visited);

        boolean[] visited1 = new boolean[n];
        visited1[0] = true;
        dfs(0, visited1);
        return ansCount;
    }

}
