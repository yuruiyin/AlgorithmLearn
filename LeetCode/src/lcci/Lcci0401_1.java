package lcci;

import java.util.ArrayList;
import java.util.List;

public class Lcci0401_1 {

    private List<Integer>[] adj;
    private boolean[] visited;

    private boolean hasPath(int start, int target) {
        // dfs
        if (start == target) {
            return true;
        }

        visited[start] = true;

        List<Integer> nextList = adj[start];
        if (nextList == null) {
            return false;
        }

        for (Integer next: nextList) {
            if (visited[next]) {
                continue;
            }

            if (hasPath(next, target)) {
                return true;
            }
        }

        return false;
    }

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        adj = new ArrayList[n];
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }

            adj[from].add(to);
        }

        visited = new boolean[n];
        return hasPath(start, target);
    }

}
