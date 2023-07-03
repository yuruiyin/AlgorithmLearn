package doubleContest.round101;

import java.util.*;

public class D {

    private int bfs(int u, int v, int n, List<Integer>[] graph) {
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        visited[v] = true;
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextList = graph[node];
                for (int next : nextList) {
                    if (visited[next]) {
                        if (next == v && level > 1) {
                            return level + 1;
                        }
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
            level++;
        }
        return -1;
    }

    // 无向无权图的最短环
    public int findShortestCycle(int n, int[][] edges) {
        // 遍历边
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int ansMin = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (graph[u].size() == 1 || graph[v].size() == 1) {
                continue;
            }
            // bfs
            int res = bfs(u, v, n, graph);
            if (res != -1) {
                ansMin = Math.min(ansMin, res);
            }
        }

        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;
    }

}
