package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1059 {

    private List<Integer>[] adj;
    private int destination;

    private boolean dfs(int from, boolean[] visited) {
        if (from == destination) {
            return true;
        }

        List<Integer> neighbors = adj[from];
        if (neighbors == null) {
            return false;
        }

        visited[from] = true;
        for (Integer next: adj[from]) {
            if (visited[next]) {
                return false;
            }

            boolean isOk = dfs(next, visited);
            if (!isOk) {
                return false;
            }
        }

        visited[from] = false;
        return true;
    }

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        adj = new ArrayList[n];
        this.destination = destination;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);
        }

        if (adj[destination] != null) {
            // 终点还有出边，不满足题目要求
            return false;
        }

        return dfs(source, new boolean[n]);
    }

}
