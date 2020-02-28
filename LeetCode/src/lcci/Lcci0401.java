package lcci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lcci0401 {

    private boolean hasPath(int n, List<Integer>[] adj, int start, int target) {
        // bfs
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextList = adj[node];
                if (nextList == null) {
                    continue;
                }

                for (Integer next: nextList) {
                    if (next == target) {
                        return true;
                    }

                    if (visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }

            adj[from].add(to);
        }

        return hasPath(n, adj, start, target);
    }

}
